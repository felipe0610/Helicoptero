package framework;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by suarezch on 23/08/2015.
 */

public abstract class CambiadorDeEstados extends Objeto {

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


    // M�todos
    public void update(int dx) {
        x -= dx;
    }

    public void draw(Canvas canvas, Paint fuenteTexto, Paint estiloCirculo) {
        
        // Dibujar texto
        canvas.drawText(texto, x-10, y-10, fuenteTexto);

        // Dibujar c�rculo
        canvas.drawCircle(x - radio, y - radio, radio, estiloCirculo);
    }


    // Obtenedores y Modificadores
    public Paint getFuenteTexto() {
        return this.fuenteTexto;
    }
    public void setFuenteTexto(Paint fuenteTexto) {
        this.fuenteTexto = fuenteTexto;
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

}