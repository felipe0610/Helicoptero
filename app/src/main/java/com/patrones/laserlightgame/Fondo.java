package com.patrones.laserlightgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Felipe on 8/20/2015.
 */
public class Fondo {

    private Bitmap image;
    private int x, y, dx;

    public Fondo(Bitmap res)
    {
        image = res;
        dx = PanelJuego.MOVESPEED;
    }
    public void update()
    {
        x+=dx;
        if(x<-PanelJuego.WIDTH){
            x=0;
        }
    }
    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y,null);
        if(x<0)
        {
            canvas.drawBitmap(image,x+ PanelJuego.HEIGHT, y, null);
        }
    }

}
