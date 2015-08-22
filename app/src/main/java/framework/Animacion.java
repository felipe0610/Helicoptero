package framework;

import android.graphics.Bitmap;

/**
 * Created by Felipe on 8/21/2015.
 */
public class Animacion {
    private Bitmap[] frames;
    private int currentFrame;
    private long startTime;
    private long delay;
    private boolean playedOnce;


    // Constructor
    public Animacion(Bitmap[] frames) {
        this.setFrames(frames);
    }


    // Métodos
    public void update() {

        long elapsed = (System.nanoTime()-startTime)/1000000;

        if(elapsed>delay)
        {
            currentFrame++;
            startTime = System.nanoTime();
        }

        if(currentFrame == frames.length){
            currentFrame = 0;
            playedOnce = true;
        }
    }


    // Obtenedores y Modificadores
    public Bitmap getImage(){
        return frames[currentFrame];
    }

    public boolean playedOnce(){return playedOnce;}

    public void setFrames(Bitmap[] frames)
    {
        this.frames = frames;
        currentFrame = 0;
        startTime = System.nanoTime();
    }

    public void setDelay(long d){delay = d;}

}