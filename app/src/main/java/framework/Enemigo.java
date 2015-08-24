package framework;
/**
 * Created by Felipe on 8/21/2015.
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.Random;

public abstract class Enemigo extends Objeto implements Cloneable{

    // Atributos
    private Bitmap grafico;
    private int puntaje;
    private int velocidad;
    private Animacion animacion;


    // Constructor
    public Enemigo(Bitmap grafico, int x, int y, int w, int h, int puntaje, int cantFotogramas) {

        super.x = x;
        super.y = y;
        super.width = w;
        super.height = h;

        this.grafico = grafico;
        this.puntaje = puntaje;
        setVelocidad();
        Bitmap[] image = new Bitmap[cantFotogramas];
        for(int i = 0; i<image.length;i++) {
            image[i] = Bitmap.createBitmap(this.grafico, 0, i*height, width, height);
        }
        animacion = new Animacion(image);
    }


    // Métodos
    public void update()
    {
        x -= velocidad;
        animacion.update();
    }

    public void draw(Canvas canvas) {
        try {
            canvas.drawBitmap(animacion.getImage(),x,y,null);
        } catch (Exception e) {}
    }


    public int getVelocidad() {
        return this.velocidad;
    }

    public Animacion getAnimacion() {
        return this.animacion;
    }

    public void setPuntaje(int puntaje){
        this.puntaje = puntaje;
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
    public void setVelocidad(){
        this.velocidad = 7 + (int)((new Random()).nextDouble()*this.puntaje /30);
        if(velocidad >60) velocidad = 60;
    }



}