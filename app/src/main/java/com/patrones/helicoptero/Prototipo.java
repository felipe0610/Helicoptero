package com.patrones.helicoptero;

import framework.Objeto;

/**
 * Created by suarezch on 22/08/2015.
 */
public abstract class Prototipo {

    // Relaciones
    private PanelJuego panelJuego;


    // Constructor
    public Prototipo(PanelJuego panelJuego) {
        this.panelJuego = panelJuego;
    }


    // M�todos a ser implementados
    public abstract Objeto clonar();


    // Obtenedores y Modificadores
    public PanelJuego getPanelJuego() {
        return this.panelJuego;
    }

}
