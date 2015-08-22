package framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Felipe on 8/21/2015.
 */
public abstract class DestruccionDeObjeto {

    // Atributos
    private Bitmap grafico;
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private Animacion animacion;


    // Constructor
    public DestruccionDeObjeto(Bitmap grafico, int x, int y, int ancho, int alto, int cantFotogramas, int retrasoAnimacion){

        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;

        this.grafico = grafico;

        Bitmap[] image = new Bitmap[cantFotogramas];
        int row = 0;
        for(int i = 0;i<image.length;i++){
            if(i%5==0 &&i>0){
                row++;
            }
            image[i] = Bitmap.createBitmap(this.grafico,(i-(5*row))* this.ancho,row* this.alto, this.ancho, this.alto);
        }

        animacion = new Animacion(image);
        animacion.setDelay(retrasoAnimacion);
    }


    // Métodos
    public void draw(Canvas canvas){
        if(!animacion.playedOnce()){
            canvas.drawBitmap(animacion.getImage(),x,y,null);
        }
    }

    public void update(){
        if (!animacion.playedOnce()){
            animacion.update();
        }
    }

}
