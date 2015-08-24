package com.patrones.helicoptero;

import framework.Objeto;

/**
 * Created by suarezch on 22/08/2015.
 */
public class PrototipoHumo extends Prototipo {

    private Humo humo;

    // Constructor
    public PrototipoHumo(PanelJuego panelJuego) {
        super(panelJuego);
    }

    // Métodos
    public Objeto clonar() {

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
