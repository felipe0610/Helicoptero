package framework;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by suarezch on 23/08/2015.
 */

public abstract class CambiadorDeEstados extends ObjetoVolador implements Cloneable{

    // Atributos
    private String texto;
    private Paint fuenteTexto;
    private int radio;
    private Paint estiloCirculo;
    private int velocidad;


    // Constructor
    public CambiadorDeEstados(int x, int y, int ancho, int alto, String texto, int radio, int velocidad) {
        super.x = x;
        super.y = y;
        super.width = ancho;
        super.height = alto;
        this.texto = texto;
        this.radio = radio;
        this.velocidad = velocidad;
    }


    // Métodos
    public void update(int dx) {
        x -= dx;
    }

    public abstract void draw(Canvas canvas);

    // Obtenedores y Modificadores
    public String getTexto() {
        return this.texto;
    }
    public Paint getFuenteTexto() {
        return this.fuenteTexto;
    }
    public void setFuenteTexto(Paint fuenteTexto) {
        this.fuenteTexto = fuenteTexto;
    }
    public int getRadio() {
        return this.radio;
    }
    public Paint getEstiloCirculo() {
        return this.estiloCirculo;
    }
    public void setEstiloCirculo(Paint estiloCirculo) {
        this.estiloCirculo = estiloCirculo;
    }
    public int getVelocidad() {
        return this.velocidad;
    }

    public Object clone() {
        Object clon = null;

        try {
            clon = super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clon;
    }

}