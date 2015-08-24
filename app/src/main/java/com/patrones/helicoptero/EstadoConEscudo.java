package com.patrones.helicoptero;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

import framework.CambiadorDeEstados;

/**
 * Created by suarezch on 23/08/2015.
 */
public class EstadoConEscudo implements IEstadoHelicoptero {

    // Atributos
    private Helicoptero helicoptero;


    // Constructor
    public EstadoConEscudo(Helicoptero helicoptero) {
        this.helicoptero = helicoptero;
    }


    // Métodos implementados
    public void draw(Canvas canvas) {

        // Dibujar el escudo
        Paint estiloCirculo = new Paint();
        estiloCirculo.setColor(Color.argb(128, 255, 255, 255));
        estiloCirculo.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(
                helicoptero.getX() + 30,
                helicoptero.getY() + 12,
                40,
                estiloCirculo
        );

        // Dibujar el helicóptero normal
        canvas.drawBitmap(
                helicoptero.getAnimacion().getImage(),
                helicoptero.getX(),
                helicoptero.getY(),
                null
        );

    }

    public void colisionar() {
        // Ya no hace helicoptero.setJugando(false) porque el escudo lo salvó del misil
        // Ahora cambia a su estado normal
        helicoptero.setEstado(new EstadoNormal(helicoptero));
    }

    public void tomarCambiador(CambiadorDeEstados cambiador) {

        if (cambiador instanceof CambiadorEscudo) {
            helicoptero.setEstado(new EstadoConEscudo(helicoptero));
        }
    }

    public Rect getRectangle() {
        return new Rect(
                helicoptero.getX(),
                helicoptero.getY(),
                helicoptero.getX()+helicoptero.getWidth(),
                helicoptero.getY()+helicoptero.getHeight()
        );
    }

}
