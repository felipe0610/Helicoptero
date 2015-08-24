package com.patrones.helicoptero;

import java.util.ArrayList;

import framework.Objeto;

/**
 * Created by suarezch on 22/08/2015.
 */
public class FabricaHumo extends Fabrica {

    private Humo humo;

    // Constructor
    public FabricaHumo(PanelJuego panelJuego) {
        super(panelJuego);
    }

    // Métodos
    public Objeto get() {

        if(humo == null){
            this. humo = new Humo(getPanelJuego().getHelicoptero().getX(),
                    getPanelJuego().getHelicoptero().getY()+10);
            return this.humo;
        }

        else{
            Humo humoNuevo = (Humo)this.humo.clone();
            humoNuevo.setX(getPanelJuego().getHelicoptero().getX());
            humoNuevo.setY(getPanelJuego().getHelicoptero().getY()+10);
            return humoNuevo;
        }
    }

}
