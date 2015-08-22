package framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.animation.Animation;

import framework.Animacion;

/**
 * Created by Felipe on 8/21/2015.
 */
public class DestruccionDeObjeto {

    // Atributos
    private int x;
    private int y;
    private int width;
    private int height;
    private int row;
    private Animacion animacion;
    private Bitmap spritesheet;


    // Constructor
    public DestruccionDeObjeto(Bitmap imagen, int x, int y, int w, int h, int numFrames, int animationDelay){

        this.x = x;
        this.y = y;
        this.height = h;
        this.width = w;

        this.spritesheet = imagen;

        Bitmap[] image = new Bitmap[numFrames];
        for(int i = 0;i<image.length;i++){
            if(i%5==0 &&i>0){
                row++;
            }
            image[i] = Bitmap.createBitmap(spritesheet,(i-(5*row))*width,row*height,width,height);
        }

        animacion = new Animacion(image);
        animacion.setDelay(animationDelay);
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
    public int getHeight(){
        return height;
    }
}
