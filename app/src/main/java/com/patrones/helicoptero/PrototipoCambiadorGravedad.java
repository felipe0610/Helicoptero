package com.patrones.helicoptero;

import java.util.Random;

import framework.Objeto;

/**
 * Created by suarezch on 24/08/2015.
 */
public class PrototipoCambiadorGravedad extends Prototipo {

    // Atributos
    private Random rand;
    private CambiadorGravedad cambiador;


    // Constructor
    public PrototipoCambiadorGravedad(PanelJuego panelJuego) {
        super(panelJuego);
        this.rand =  new Random();
    }

    // Métodos
    public Objeto clonar() {

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
