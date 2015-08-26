package framework;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Felipe on 8/21/2015.
 */

public abstract class Rastro extends ObjetoVolador implements Cloneable{

    // Atributos
    public int radio;


    // Constructor
    public Rastro(int x, int y, int radio) {
        super.x = x;
        super.y = y;
        this.radio = radio;
    }


    // Métodos
    public void update(int dx) {
        x -= dx;
    }

    public void draw(Canvas canvas, int color, Paint.Style paintStyle) {
        
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(paintStyle);

        canvas.drawCircle(x- radio, y- radio, radio, paint);
        canvas.drawCircle(x- radio +2, y- radio -2, radio,paint);
        canvas.drawCircle(x- radio +4, y- radio +1, radio, paint);
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