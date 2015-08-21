package com.patrones.laserlightgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Felipe on 8/21/2015.
 */
public class Jugador extends Objeto {
    private Bitmap spritesheet;
    private int score;

    private boolean up;
    private boolean playing;
    private Animacion animacion = new Animacion();
    private long startTime;

    public Jugador(Bitmap res, int w, int h, int numFrames) {

        super.x = 100;
        super.y = PanelJuego.HEIGHT / 2;
        super.dy = 0;
        super.height = h;
        super.width = w;

        this.spritesheet = res;
        this.score = 0;

        Bitmap[] image = new Bitmap[numFrames];
        for (int i = 0; i < image.length; i++)
        {
            image[i] = Bitmap.createBitmap(spritesheet, i*width, 0, width, height);
        }

        animacion.setFrames(image);
        animacion.setDelay(10);
        startTime = System.nanoTime();

    }

    public void setUp(boolean b){up = b;}

    public void update()
    {
        long elapsed = (System.nanoTime()-startTime)/1000000;
        if(elapsed>100)
        {
            score++;
            startTime = System.nanoTime();
        }
        animacion.update();

        if(up){
            dy -=1.0;

        }
        else{
            dy +=1.0;
        }

        if(dy>14)dy = 14;
        if(dy<-14)dy = -14;

        y += dy*2;

    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(animacion.getImage(),x,y,null);
    }
    public int getScore(){return score;}
    public boolean getPlaying(){return playing;}
    public void setPlaying(boolean b){playing = b;}
    public void resetDY(){dy = 0;}
    public void resetScore(){score = 0;}
}