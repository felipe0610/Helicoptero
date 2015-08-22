package com.patrones.helicoptero;
/**
 * Created by Felipe on 8/21/2015.
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.Random;

import framework.Enemigo;

public class Misil extends Enemigo {

    // Constructor
    public Misil(Bitmap imagen, int x, int y, int s) {
        super(
                imagen,
                x,
                y,
                45,
                15,
                s,
                13
        );
        this.getAnimacion().setDelay(100-this.getSpeed());
    }


    // Métodos
    @Override
    public int getWidth() {
        //Evita la colisión contra la llama del proyectil
        return width - 10;
    }

}