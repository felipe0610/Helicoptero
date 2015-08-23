package com.patrones.helicoptero;

import framework.Objeto;

/**
 * Created by suarezch on 22/08/2015.
 */
public abstract class Fabrica {

    // Relaciones
    private PanelJuego panelJuego;


    // Constructor
    public Fabrica(PanelJuego panelJuego) {
        this.panelJuego = panelJuego;
    }


    // Métodos a ser implementados
    public abstract Objeto crear();

    // Obtenedores y Modificadores
    public PanelJuego getPanelJuego() {
        return this.panelJuego;
    }

}
