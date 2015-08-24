package com.patrones.helicoptero;

import android.graphics.BitmapFactory;
import android.graphics.Rect;
import com.patrones.laserlightgame.R;
import java.util.ArrayList;
import java.util.Random;
import framework.Objeto;

/**
 * Created by suarezch on 22/08/2015.
 */
public class FabricaMisiles extends Fabrica {

    // Atributos

    private Random rand;
    private Misil misil;

    // Constructor
    public FabricaMisiles(PanelJuego panelJuego) {
        super(panelJuego);
        this.rand =  new Random();
    }

    // Métodos
    public Objeto get() {

        //Se crea el prototipo, el primer misil va en el centro
        if(misil == null){
            this.misil = new Misil(BitmapFactory.decodeResource(getPanelJuego().getResources(),R.drawable.
                    missile),getPanelJuego().WIDTH + 10, getPanelJuego().HEIGHT/2, getPanelJuego().getHelicoptero().getPuntaje());
            return this.misil;
        }

        else{
            Misil misilNuevo = (Misil)misil.clone();
            misilNuevo.setX(getPanelJuego().WIDTH);
            misilNuevo.setY((int) (rand.nextDouble() * (getPanelJuego().HEIGHT)));
            misilNuevo.setPuntaje(getPanelJuego().getHelicoptero().getPuntaje());
            misilNuevo.setVelocidad();
            misilNuevo.getAnimacion().setDelay(100 - misilNuevo.getVelocidad());
            return misilNuevo;
        }

    }

}
