package com.patrones.helicoptero;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import framework.Rastro;

/**
 * Created by Felipe on 8/21/2015.
 */

public class Humo extends Rastro {

    // Constructor
    public Humo(int x, int y) {
        super(x, y, 5);
    }


    // Métodos
    public void update()
    {
        super.update(10);
    }

    public void draw(Canvas canvas)
    {
        super.draw(canvas, Color.GRAY, Paint.Style.FILL);
    }

}