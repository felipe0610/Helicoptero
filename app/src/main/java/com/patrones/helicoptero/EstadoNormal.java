package com.patrones.helicoptero;

import android.graphics.Canvas;

import framework.CambiadorDeEstados;

/**
 * Created by suarezch on 23/08/2015.
 */
public class EstadoNormal implements IEstadoHelicoptero {

    // Atributos
    private Helicoptero helicoptero;


    // Constructor
    public EstadoNormal(Helicoptero helicoptero) {
        this.helicoptero = helicoptero;
    }


    // Métodos implementados
    public void draw(Canvas canvas) {
        canvas.drawBitmap(
                helicoptero.getAnimacion().getImage(),
                helicoptero.getX(),
                helicoptero.getY(),
                null
        );
    }

    public void colisionar() {
        helicoptero.setJugando(false);
    }

    public void tomarCambiador(CambiadorDeEstados cambiador) {

        if (cambiador instanceof CambiadorEscudo) {
            helicoptero.setEstado(new EstadoConEscudo(helicoptero));
        }
    }

}
