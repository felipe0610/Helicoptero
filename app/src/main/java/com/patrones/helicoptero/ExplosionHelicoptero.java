package com.patrones.helicoptero;

import android.graphics.Bitmap;

import framework.DestruccionDeObjeto;

/**
 * Created by Felipe on 8/21/2015.
 */
public class ExplosionHelicoptero extends DestruccionDeObjeto {

    // Constructor
    public ExplosionHelicoptero(Bitmap imagen, Helicoptero helicoptero) {
        super(
                imagen,
                helicoptero.getX(),
                helicoptero.getY()-30,
                100,
                100,
                25,
                10
        );
    }


}