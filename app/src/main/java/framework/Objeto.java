package framework;

import android.graphics.Rect;

/**
 * Created by Felipe on 8/21/2015.
 */
public abstract class Objeto {
    protected int x;
    protected int y;
    protected int dy;
    protected int dx;
    protected int width;
    protected int height;

    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getDy()
    {
        return dy;
    }
    public int getHeight()
    {
        return height;
    }
    public int getWidth()
    {
        return width;
    }
    public Rect getRectangle()
    {
        return new Rect(x, y, x+width, y+height);
    }

}