package framework;
/**
 * Created by Felipe on 8/21/2015.
 */
import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.Random;

public class Enemigo extends Objeto {

    // Atributos
    private Bitmap spritesheet;
    private int score;
    private int speed;
    private Random rand = new Random();
    private Animacion animacion;


    // Constructor
    public Enemigo(Bitmap imagen, int x, int y, int w, int h, int s, int numFrames) {

        super.x = x;
        super.y = y;
        super.width = w;
        super.height = h;

        this.spritesheet = imagen;
        this.score = s;
        this.speed = 7 + (int)(rand.nextDouble()*score/30);
        if(speed>40)speed = 40;

        Bitmap[] image = new Bitmap[numFrames];
        for(int i = 0; i<image.length;i++) {
            image[i] = Bitmap.createBitmap(spritesheet, 0, i*height, width, height);
        }

        animacion = new Animacion(image);
    }


    // Métodos
    public void update()
    {
        x -= speed;
        animacion.update();
    }

    public void draw(Canvas canvas) {
        try {
            canvas.drawBitmap(animacion.getImage(),x,y,null);
        } catch (Exception e) {}
    }


    public int getSpeed() {
        return this.speed;
    }

    public Animacion getAnimacion() {
        return this.animacion;
    }

}