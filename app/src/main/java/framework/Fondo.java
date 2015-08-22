package framework;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import com.patrones.helicoptero.PanelJuego;

/**
 * Created by Felipe on 8/20/2015.
 */
public class Fondo {

    // Atributos
    private PanelJuego panelJuego;
    private Bitmap image;
    private int x;
    private int y;
    private int dx;


    // Constructor
    public Fondo(PanelJuego panelJuego, Bitmap imagen) {
        this.panelJuego = panelJuego;
        this.image = imagen;
        this.dx = panelJuego.MOVESPEED;
    }


    // Métodos
    public void update() {
        x += dx;
        if (x < -panelJuego.WIDTH) {
            x = 0;
        }
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(image, x, y, null);
        if(x<0) {
            canvas.drawBitmap(image, x+panelJuego.HEIGHT, y, null); // x+PanelJuego.HEIGHT ??? no debería de ser x+PanelJuego.WIDTH?
        }
    }

}
