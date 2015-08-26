package com.patrones.helicoptero;

import java.util.Random;

import framework.ObjetoVolador;

/**
 * Created by suarezch on 23/08/2015.
 */
public class PrototipoCambiadorEscudo extends Prototipo {

    // Atributos
    private Random rand;
    private CambiadorEscudo cambiadorEscudo;


    // Constructor
    public PrototipoCambiadorEscudo(PanelJuego panelJuego) {
        super(panelJuego);
        this.rand =  new Random();
    }

    // Métodos
    public ObjetoVolador clonar() {

        if(cambiadorEscudo == null){
            this.cambiadorEscudo = new CambiadorEscudo(getPanelJuego().WIDTH+10,(int)(rand.nextDouble()*(getPanelJuego().HEIGHT)));
            return this.cambiadorEscudo;
        }

        else{
            CambiadorEscudo cambiadorEscudoNuevo = (CambiadorEscudo)this.cambiadorEscudo.clone();
            cambiadorEscudoNuevo.setX(getPanelJuego().WIDTH+10);
            cambiadorEscudoNuevo.setY((int) (rand.nextDouble() * (getPanelJuego().HEIGHT)));
            return cambiadorEscudoNuevo;
        }

    }
}
