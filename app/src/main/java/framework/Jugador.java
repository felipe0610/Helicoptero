package framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;


/**
 * Created by Felipe on 8/21/2015.
 */
public abstract class Jugador extends Objeto {

    // Atributos
    private Bitmap grafico;
    private int puntaje;
    private boolean tocandoPantalla;
    private boolean jugando;
    private long tiempoInicio;
    private Animacion animacion;


    // Constructor
    public Jugador(int x, int y, Bitmap grafico, int ancho, int alto, int cantFotogramas, int retrasoAnimacion) {

        super.x = x;
        super.y = y;
        super.dy = 0;
        super.height = alto;
        super.width = ancho;

        this.grafico = grafico;
        this.puntaje = 0;
        this.tiempoInicio = System.nanoTime();

        Bitmap[] image = new Bitmap[cantFotogramas];
        for (int i = 0; i < image.length; i++) {
            image[i] = Bitmap.createBitmap(this.grafico, i*width, 0, width, height);
        }
        this.animacion = new Animacion(image);
        this.animacion.setDelay(retrasoAnimacion);
    }


    // Métodos
    public void update(int deltaY, int maxDy, int dyFactor)
    {
        long elapsed = (System.nanoTime()- tiempoInicio)/1000000;
        if(elapsed > 100)
        {
            puntaje++;
            tiempoInicio = System.nanoTime();
        }
        animacion.update();

        if(tocandoPantalla){
            this.dy -= deltaY;

        }
        else{
            this.dy += deltaY;
        }

        if(dy > maxDy)dy = maxDy;
        if(dy < -maxDy)dy = -maxDy;

        this.y += dy * dyFactor;
        System.out.println("dy: " + dy);

    }

    public void resetDY() {
        dy = 0;
    }

    public void resetPuntaje() {
        puntaje = 0;
    }

    public int getPuntaje(){return puntaje;}
    public void setTocandoPantalla(boolean b){
        tocandoPantalla = b;}
    public boolean getJugando(){return jugando;}
    public void setJugando(boolean b){
        jugando = b;
    }
    public Animacion getAnimacion () {
        return this.animacion;
    }

}