package framework;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by Felipe on 8/21/2015.
 */

public class Rastro extends Objeto {

    // Atributos
    public int r;


    // Constructor
    public Rastro(int x, int y, int r) {
        super.x = x;
        super.y = y;
        this.r = r;
    }


    // Métodos
    public void update(int dx) {
        x -= dx;
    }

    public void draw(Canvas canvas, int color, Paint.Style paintStyle) {
        
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(paintStyle);

        canvas.drawCircle(x-r, y-r, r, paint);
        canvas.drawCircle(x-r+2, y-r-2,r,paint);
        canvas.drawCircle(x-r+4, y-r+1, r, paint);
    }

}