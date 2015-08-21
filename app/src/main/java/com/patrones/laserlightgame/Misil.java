package com.patrones.laserlightgame;
/**
 * Created by Felipe on 8/21/2015.
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

public class Misil extends Objeto {
    private int score;
    private int speed;
    private Random rand = new Random();
    private Animacion animacion = new Animacion();
    private Bitmap spritesheet;

    public Misil(Bitmap res, int x, int y, int w, int h, int s, int numFrames)
    {
        super.x = x;
        super.y = y;
        width = w;
        height = h;
        score = s;

        speed = 7 + (int) (rand.nextDouble()*score/30);

        //Velocidad del misil
        if(speed>40)speed = 40;

        Bitmap[] image = new Bitmap[numFrames];

        spritesheet = res;

        for(int i = 0; i<image.length;i++)
        {
            image[i] = Bitmap.createBitmap(spritesheet, 0, i*height, width, height);
        }

        animacion.setFrames(image);
        animacion.setDelay(100-speed);

    }
    public void update()
    {
        x-=speed;
        animacion.update();
    }
    public void draw(Canvas canvas)
    {
        try{
            canvas.drawBitmap(animacion.getImage(),x,y,null);
        }catch(Exception e){}
    }

    @Override
    public int getWidth()
    {
        //Evita la colision contra la llama del proyectil
        return width-10;
    }

}