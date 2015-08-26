package com.patrones.helicoptero;
/**
 * Created by Felipe on 8/21/2015.
 */
import android.graphics.Bitmap;

import framework.ObjetoDisparable;

public class Misil extends ObjetoDisparable {

    // Constructor
    public Misil(Bitmap imagen, int x, int y, int puntaje) {
        super(
                imagen,
                x,
                y,
                45,
                15,
                puntaje,
                13
        );
        this.getAnimacion().setDelay(100-this.getVelocidad());
    }


    // Métodos
    @Override
    public int getWidth() {
        //Evita la colisión contra la llama del proyectil
        return width - 10;
    }

}