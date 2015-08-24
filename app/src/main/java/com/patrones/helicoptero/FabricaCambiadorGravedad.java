package com.patrones.helicoptero;

import java.util.Random;

import framework.Objeto;

/**
 * Created by suarezch on 24/08/2015.
 */
public class FabricaCambiadorGravedad extends Fabrica {

    // Atributos
    private Random rand;
    private CambiadorGravedad cambiador;


    // Constructor
    public FabricaCambiadorGravedad(PanelJuego panelJuego) {
        super(panelJuego);
        this.rand =  new Random();
    }

    // Métodos
    public Objeto get() {

        if(cambiador == null){
            this.cambiador = new CambiadorGravedad(getPanelJuego().WIDTH+10,(int)(rand.nextDouble()*(getPanelJuego().HEIGHT)));
            return this.cambiador;
        }

        else{
            CambiadorGravedad cambiadorNuevo = (CambiadorGravedad)this.cambiador.clone();
            cambiadorNuevo.setX(getPanelJuego().WIDTH+10);
            cambiadorNuevo.setY((int) (rand.nextDouble() * (getPanelJuego().HEIGHT)));
            return cambiadorNuevo;
        }

    }
}
