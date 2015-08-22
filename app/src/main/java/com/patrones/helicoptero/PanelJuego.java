package com.patrones.helicoptero;

/**
 * Created by Felipe on 8/20/2015.
 */
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.patrones.laserlightgame.R;
import java.util.ArrayList;
import java.util.Random;
import framework.Fondo;
import framework.Objeto;


public class PanelJuego extends SurfaceView implements SurfaceHolder.Callback
{
    public static final int WIDTH = 856;
    public static final int HEIGHT = 480;
    public static final int MOVESPEED = -5;
    private long smokeStartTime;
    private long missileStartTime;
    private MainThread thread;
    private Fondo bg;
    private Helicoptero helicoptero;
    private ArrayList<Humo> smoke;
    private ArrayList<Misil> misil;
    private Random rand = new Random();


    public PanelJuego(Context context)
    {
        super(context);


        //Callback al surfaceholder para interceptar events
        getHolder().addCallback(this);

        thread = new MainThread(getHolder(), this);

        //Permite focus para poder interceptar events
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        int counter = 0;
        while(retry && counter<1000)
        {
            counter++;
            try{thread.setRunning(false);
                thread.join();
                retry = false;

            }catch(InterruptedException e){e.printStackTrace();}

        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){

        bg = new Fondo(this, BitmapFactory.decodeResource(getResources(), R.drawable.grassbg1));
        helicoptero = new Helicoptero(BitmapFactory.decodeResource(getResources(), R.drawable.helicopter));
        smoke = new ArrayList<Humo>();
        misil = new ArrayList<Misil>();
        smokeStartTime=  System.nanoTime();
        missileStartTime = System.nanoTime();



        //Empieza el juego
        thread.setRunning(true);
        thread.start();

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN){

            if(!helicoptero.getPlaying())
            {
                helicoptero.setPlaying(true);
            }
            else
            {
                helicoptero.setUp(true);
            }
            return true;
        }
        if(event.getAction()==MotionEvent.ACTION_UP)
        {
            helicoptero.setUp(false);
            return true;
        }

        return super.onTouchEvent(event);
    }

    public void update()

    {
        if(helicoptero.getPlaying()) {

            bg.update();
            helicoptero.update();

            //Anade misiles al timer
            long missileElapsed = (System.nanoTime()-missileStartTime)/1000000;
            if(missileElapsed >(2000 - helicoptero.getScore()/4)){

                System.out.println("making missile");
                //first missile always goes down the middle
                if (misil.size()==0) {
                    misil.add(new Misil(BitmapFactory.decodeResource(getResources(),R.drawable.
                            missile),WIDTH + 10, HEIGHT/2, helicoptero.getScore()));
                } else {
                    misil.add(new Misil(BitmapFactory.decodeResource(getResources(),R.drawable.missile),
                            WIDTH+10, (int)(rand.nextDouble()*(HEIGHT)), helicoptero.getScore()));
                }

                //reset timer
                missileStartTime = System.nanoTime();
            }
            //loop a cada misil y revisa colision, remueve misiles que hagan colision
            for(int i = 0; i< misil.size();i++)
            {
                //update missile
                misil.get(i).update();

                if(collision(misil.get(i), helicoptero))
                {
                    misil.remove(i);
                    helicoptero.setPlaying(false);
                    break;
                }
                //remueve el misil si se sale de la pantalla
                if(misil.get(i).getX()<-100)
                {
                    misil.remove(i);
                    break;
                }
            }



            //anade el humo
            long elapsed = (System.nanoTime() - smokeStartTime)/1000000;
            if(elapsed > 120){
                smoke.add(new Humo(helicoptero.getX(), helicoptero.getY()+10));
                smokeStartTime = System.nanoTime();
            }

            for(int i = 0; i<smoke.size();i++)
            {
                smoke.get(i).update();
                if(smoke.get(i).getX()<-10)
                {
                    smoke.remove(i);
                }
            }
        }
    }
    public boolean collision(Objeto a, Objeto b)
    {
        if(Rect.intersects(a.getRectangle(),b.getRectangle()))
        {
            return true;
        }
        return false;
    }
    @Override
    public void draw(Canvas canvas)
    {
        final float scaleFactorX = getWidth()/(WIDTH*1.f);
        final float scaleFactorY = getHeight()/(HEIGHT*1.f);

        if(canvas!=null) {
            final int savedState = canvas.save();

            canvas.scale(scaleFactorX, scaleFactorY);
            bg.draw(canvas);
            helicoptero.draw(canvas);
            //draw humo
            for(Humo sp: smoke)
            {
                sp.draw(canvas);
            }
            //draw misiles
            for(Misil m: misil)
            {
                m.draw(canvas);
            }

            canvas.restoreToCount(savedState);
        }
    }


}