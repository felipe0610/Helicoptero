package com.patrones.helicoptero;

import framework.ObjetoVolador;

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


    // Métodos a ser implementados
    public abstract ObjetoVolador clonar();


    // Obtenedores y Modificadores
    public PanelJuego getPanelJuego() {
        return this.panelJuego;
    }

}
