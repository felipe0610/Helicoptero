package com.patrones.helicoptero;

import java.util.Random;

import framework.Objeto;

/**
 * Created by suarezch on 23/08/2015.
 */
public class FabricaPonerEscudo extends Fabrica {

    // Atributos
    private Random rand;


    // Constructor
    public FabricaPonerEscudo(PanelJuego panelJuego) {
        super(panelJuego);
        this.rand =  new Random();
    }

    // Métodos
    public Objeto crear() {
        return new PonerEscudo(
                getPanelJuego().WIDTH+10,
                (int)(rand.nextDouble()*(getPanelJuego().HEIGHT))
        );
    }
}
