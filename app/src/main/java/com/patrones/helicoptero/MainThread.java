package com.patrones.helicoptero;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

/**
 * Created by Felipe on 8/20/2015.
 */
public class MainThread extends Thread
{
    private int FPS = 30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private PanelJuego panelJuego;
    private boolean running;
    public static Canvas canvas;

    public MainThread(SurfaceHolder surfaceHolder, PanelJuego panelJuego)
    {
        super();
        this.surfaceHolder = surfaceHolder;
        this.panelJuego = panelJuego;
    }
    @Override
    public void run()
    {
        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount =0;
        long targetTime = 1000/FPS;

        while(running) {
            startTime = System.nanoTime();
            canvas = null;

            //Canvas lock para poder editar los pixeles
            try {
                canvas = this.surfaceHolder.lockCanvas();
                synchronized (surfaceHolder) {
                    this.panelJuego.update();
                    this.panelJuego.draw(canvas);
                }
            } catch (Exception e) {
            }
            finally{
                if(canvas!=null)
                {
                    try {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    catch(Exception e){e.printStackTrace();}
                }
            }




            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime-timeMillis;

            try{
                this.sleep(waitTime);
            }catch(Exception e){}

            totalTime += System.nanoTime()-startTime;
            frameCount++;
            if(frameCount == FPS)
            {
                averageFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount =0;
                totalTime = 0;
            }
        }
    }
    public void setRunning(boolean b)
    {
        running=b;
    }
}
