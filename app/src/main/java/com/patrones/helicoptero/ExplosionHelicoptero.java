package com.patrones.helicoptero;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import com.patrones.laserlightgame.R;

import framework.DestruccionDeObjeto;
import framework.Jugador;

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