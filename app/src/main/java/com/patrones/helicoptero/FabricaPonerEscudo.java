package com.patrones.helicoptero;

import java.util.Random;

import framework.Objeto;

/**
 * Created by suarezch on 23/08/2015.
 */
public class FabricaPonerEscudo extends Fabrica {

    // Atributos
    private Random rand;
    private CambiadorEscudo cambiadorEscudo;


    // Constructor
    public FabricaPonerEscudo(PanelJuego panelJuego) {
        super(panelJuego);
        this.rand =  new Random();
    }

    // Métodos
    public Objeto get() {

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
