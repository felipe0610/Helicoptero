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


    // Constructor
    public FabricaMisiles(PanelJuego panelJuego) {
        super(panelJuego);
        this.rand =  new Random();
    }

    // Métodos
    public Objeto crear() {
        return new Misil(
                BitmapFactory.decodeResource(getPanelJuego().getResources(),R.drawable.missile),
                getPanelJuego().WIDTH+10,
                (int)(rand.nextDouble()*(getPanelJuego().HEIGHT)),
                getPanelJuego().getHelicoptero().getPuntaje()
        );
    }

}
