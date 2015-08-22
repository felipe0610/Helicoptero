package com.patrones.helicoptero;

/**
 * Created by Felipe on 8/20/2015.
 */
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.patrones.laserlightgame.R;
import java.util.ArrayList;
import java.util.Random;
import framework.Fondo;
import framework.Objeto;


public class PanelJuego extends SurfaceView implements SurfaceHolder.Callback
{
    public static final int WIDTH = 856; //Ancho del fondo del juego
    public static final int HEIGHT = 480; //Alto del fondo del juego
    public static final int MOVESPEED = -5;
    private long smokeStartTime;
    private long missileStartTime;
    private MainThread thread;
    private Fondo bg;
    private Helicoptero helicoptero;
    private ArrayList<Humo> smoke;
    private ArrayList<Misil> misiles;
    private Random rand = new Random();
    private boolean newGameCreated;

    //Variables para cuando el jugador muere
    private ExplosionHelicoptero explosion;
    private long startReset;

    //Reset indica el tiempo entre que el jugador muere, y vuelve a comenzar un juego nuevo. Permite un lapso de tiempo entre la muerte del jugador y un nuevo comienzo.
    private boolean reset;
    private boolean dissapear;
    private boolean started;
    private int best;

    public PanelJuego(Context context)
    {
        super(context);


        //Callback al surfaceholder para interceptar events
        getHolder().addCallback(this);

        //Permite focus para poder interceptar events
        setFocusable(true);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){}

    @Override
    public void surfaceDestroyed(SurfaceHolder holder){
        boolean retry = true;
        int counter = 0;
        while(retry && counter<1000)
        {
            counter++;
            try{thread.setRunning(false);
                thread.join();
                retry = false;
                thread = null;

            }catch(InterruptedException e){e.printStackTrace();}

        }

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder){

        bg = new Fondo(this, BitmapFactory.decodeResource(getResources(), R.drawable.grassbg1));
        helicoptero = new Helicoptero(BitmapFactory.decodeResource(getResources(), R.drawable.helicopter));
        smoke = new ArrayList<Humo>();
        misiles = new ArrayList<Misil>();
        smokeStartTime=  System.nanoTime();
        missileStartTime = System.nanoTime();

        thread = new MainThread(getHolder(),this);

        //Empieza el juego
        thread.setRunning(true);
        thread.start();

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN){

            if(!helicoptero.getJugando()&&newGameCreated && reset)
            {
                helicoptero.setJugando(true);
                helicoptero.setTocandoPantalla(true);
            }
            if(helicoptero.getJugando()){
                if(!started)started = true;
                reset = false;
                helicoptero.setTocandoPantalla(true);
            }
            return true;
        }

        if(event.getAction()==MotionEvent.ACTION_UP)
        {
            helicoptero.setTocandoPantalla(false);
            return true;
        }

        return super.onTouchEvent(event);
    }

    public void update()

    {
        if(helicoptero.getJugando()) {

            bg.update();
            helicoptero.update();

            //Revisa que el jugador no se salga de la pantalla
            if (fueraPantalla()) {
                helicoptero.setJugando(false);
            }

            //Anade misiles al timer
            long missileElapsed = (System.nanoTime()-missileStartTime)/1000000;
            if(missileElapsed >(2000 - helicoptero.getPuntaje()/4)){

                System.out.println("making missile");
                //first missile always goes down the middle
                if (misiles.size()==0) {
                    misiles.add(new Misil(BitmapFactory.decodeResource(getResources(),R.drawable.
                            missile),WIDTH + 10, HEIGHT/2, helicoptero.getPuntaje()));
                } else {
                    misiles.add(new Misil(BitmapFactory.decodeResource(getResources(),R.drawable.missile),
                            WIDTH+10, (int)(rand.nextDouble()*(HEIGHT)), helicoptero.getPuntaje()));
                }

                //reset timer
                missileStartTime = System.nanoTime();
            }
            //loop a cada misil y revisa colision, remueve misiles que hagan colision
            for(int i = 0; i< misiles.size();i++)
            {
                //update missile
                misiles.get(i).update();

                if(collision(misiles.get(i), helicoptero))
                {
                    misiles.remove(i);
                    helicoptero.setJugando(false);
                    break;
                }
                //remueve el misil si se sale de la pantalla
                if(misiles.get(i).getX()<-100)
                {
                    misiles.remove(i);
                    break;
                }
            }



            //anade el humo
            long elapsed = (System.nanoTime() - smokeStartTime)/1000000;
            if(elapsed > 120){
                smoke.add(new Humo(helicoptero.getX(), helicoptero.getY()+10));
                smokeStartTime = System.nanoTime();
            }

            for(int i = 0; i<smoke.size();i++)
            {
                smoke.get(i).update();
                if(smoke.get(i).getX()<-10)
                {
                    smoke.remove(i);
                }
            }
        }
        else
        {

            helicoptero.resetDY();
            if(!reset){
                newGameCreated = false;
                startReset = System.nanoTime();
                reset = true;
                dissapear = true;
                explosion = new ExplosionHelicoptero(BitmapFactory.decodeResource(getResources(),R.drawable.explosion),helicoptero);
            }

            explosion.update();
            long resetElapsed = (System.nanoTime()-startReset)/1000000;

            if(resetElapsed > 2500 && !newGameCreated){
                newGame();
            }
        }
    }

    //Funcion que revisa la posicion el jugador dentro de la pantalla
    public boolean fueraPantalla(){
        if(helicoptero.getY() <= 0){
            return true;
        }

        else if(helicoptero.getY() >= HEIGHT-50){
            return true;
        }

        return false;

    }
    public boolean collision(Objeto a, Objeto b)
    {
        if(Rect.intersects(a.getRectangle(), b.getRectangle()))
        {
            return true;
        }
        return false;
    }
    @Override
    public void draw(Canvas canvas)
    {
        final float scaleFactorX = getWidth()/(WIDTH*1.f);
        final float scaleFactorY = getHeight()/(HEIGHT*1.f);

        if(canvas!=null) {
            final int savedState = canvas.save();

            canvas.scale(scaleFactorX, scaleFactorY);
            bg.draw(canvas);

            if(!dissapear){
                helicoptero.draw(canvas);
            }

            //draw humo
            for(Humo sp: smoke)
            {
                sp.draw(canvas);
            }
            //draw misiles
            for(Misil m: misiles)
            {
                m.draw(canvas);
            }

            //draw explosion
            if(started)
            {
                explosion.draw(canvas);
            }

            drawText(canvas);
            canvas.restoreToCount(savedState);


            canvas.restoreToCount(savedState);
        }
    }

    public void newGame(){
        dissapear = false;
        misiles.clear();
        smoke.clear();

        //Revisa el puntaje para el jugador en panalla
        helicoptero.resetDY();
        if(helicoptero.getPuntaje() > best){
            best = helicoptero.getPuntaje();
        }

        helicoptero.resetPuntaje();
        helicoptero.setY(HEIGHT/2);



        newGameCreated = true;
    }

    public void drawText(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(30);
        paint.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        canvas.drawText("DISTANCIA: " + (helicoptero.getPuntaje() * 3), 10, HEIGHT - 10, paint);
        canvas.drawText("MEJOR: " + best, WIDTH - 215, HEIGHT - 10, paint);
    }


}