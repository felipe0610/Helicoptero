package com.patrones.helicoptero;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import com.patrones.laserlightgame.R;

import framework.Jugador;

/**
 * Created by Felipe on 8/21/2015.
 */
public class Helicoptero extends Jugador {

    // Constructor
    public Helicoptero(Bitmap imagen) {
        super(
                100,
                PanelJuego.HEIGHT / 2,
                imagen,
                65,
                25,
                3,
                10
        );
    }


    // Métodos
    public void update() {
        super.update(1, 14, 2);
    }

}