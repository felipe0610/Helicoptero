package com.patrones.helicoptero;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import framework.CambiadorDeEstados;

/**
 * Created by suarezch on 23/08/2015.
 */
public class CambiadorEscudo extends CambiadorDeEstados {

    // Constructor
    public CambiadorEscudo(int x, int y) {
        super(x, y, 60, 60, "ESCUDO", 30, 10);

        // Para el texto
        Paint fuenteTexto = new Paint();
        fuenteTexto.setColor(Color.BLUE);
        fuenteTexto.setTextSize(12);
        fuenteTexto.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        this.setFuenteTexto(fuenteTexto);

        // Para el círculo
        Paint estiloCirculo = new Paint();
        estiloCirculo.setColor(Color.YELLOW);
        estiloCirculo.setStyle(Paint.Style.FILL_AND_STROKE);
        this.setEstiloCirculo(estiloCirculo);
    }


    // Métodos
    public void update()
    {
        super.update(this.getVelocidad());
    }

    public void draw(Canvas canvas) {
        super.draw(canvas, this.getFuenteTexto(), this.getEstiloCirculo());
    }
}
