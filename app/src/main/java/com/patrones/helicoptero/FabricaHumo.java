package com.patrones.helicoptero;

import java.util.ArrayList;

import framework.Objeto;

/**
 * Created by suarezch on 22/08/2015.
 */
public class FabricaHumo extends Fabrica {

    // Constructor
    public FabricaHumo(PanelJuego panelJuego) {
        super(panelJuego);
    }

    // Métodos
    public Objeto crear() {
        return new Humo(
                getPanelJuego().getHelicoptero().getX(),
                getPanelJuego().getHelicoptero().getY()+10
        );
    }

}
