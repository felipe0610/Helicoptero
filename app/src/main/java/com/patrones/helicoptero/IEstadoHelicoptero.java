package com.patrones.helicoptero;

import android.graphics.Canvas;

import framework.CambiadorDeEstados;

/**
 * Created by suarezch on 23/08/2015.
 */
public interface IEstadoHelicoptero {

    public void draw(Canvas canvas);

    public void colisionar();

    public void tomarCambiador(CambiadorDeEstados cambiador);
}
