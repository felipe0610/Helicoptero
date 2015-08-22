package framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;


/**
 * Created by Felipe on 8/21/2015.
 */
public class Jugador extends Objeto {

    // Atributos
    private Bitmap spritesheet;
    private int score;
    private boolean up;
    private boolean playing;
    private Animacion animacion;
    private long startTime;


    // Constructor
    public Jugador(int x, int y, Bitmap imagen, int w, int h, int numFrames, int animationDelay) {

        super.x = x;
        super.y = y;
        super.dy = 0;
        super.height = h;
        super.width = w;

        this.spritesheet = imagen;
        this.score = 0;

        Bitmap[] image = new Bitmap[numFrames];
        for (int i = 0; i < image.length; i++) {
            image[i] = Bitmap.createBitmap(spritesheet, i*width, 0, width, height);
        }

        animacion = new Animacion(image);
        animacion.setDelay(animationDelay);
        startTime = System.nanoTime();
    }


    // Métodos
    public void update(int dy, int maxDy, int dyFactor)
    {
        long elapsed = (System.nanoTime()-startTime)/1000000;
        if(elapsed > 100)
        {
            score++;
            startTime = System.nanoTime();
        }
        animacion.update();

        if(up){
            this.dy -= dy;

        }
        else{
            this.dy += dy;
        }

        if(dy > maxDy)dy = maxDy;
        if(dy < -maxDy)dy = -maxDy;

        y += dy * dyFactor;
        System.out.println("y: " + y);

    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(animacion.getImage(),x,y,null);
    }
    public int getScore(){return score;}
    public void setUp(boolean b){up = b;}
    public boolean getUp(){return up;}
    public boolean getPlaying(){return playing;}
    public void setPlaying(boolean b){playing = b;}
    public void resetDY(){dy = 0;}
    public void resetScore(){score = 0;}
}