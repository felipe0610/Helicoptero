package com.patrones.helicoptero;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import framework.CambiadorDeEstados;

/**
 * Created by suarezch on 23/08/2015.
 */
public class PonerEscudo extends CambiadorDeEstados {

    // Constructor
    public PonerEscudo(int x, int y) {
        super(x, y, 20, 20, "ESCUDO", 20, 10);

        // Para el texto
        Paint fuenteTexto = new Paint();
        fuenteTexto.setColor(Color.CYAN);
        fuenteTexto.setTextSize(16);
        fuenteTexto.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        this.setFuenteTexto(fuenteTexto);

        // Para el círculo
        Paint estiloCirculo = new Paint();
        estiloCirculo.setColor(Color.CYAN);
        estiloCirculo.setStyle(Paint.Style.FILL);
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
