package com.patrones.helicoptero;

import android.graphics.Bitmap;

import framework.JugadorAeronave;

/**
 * Created by Felipe on 8/21/2015.
 */
public class Helicoptero extends JugadorAeronave {

    // Atributos
    private IEstadoHelicoptero estado;

    // Constructor
    public Helicoptero(Bitmap imagen) {
        super(
                100,
                PanelJuego.HEIGHT / 2,
                imagen,
                65,
                25,
                3,
                10,
                1
        );
        setEstadoInicial();
    }


    // Métodos
    public void update() {
        super.update(1, 14);
    }


    // Obtenedores y Modificadores
    public IEstadoHelicoptero getEstado() {
        return this.estado;
    }

    public void setEstado(IEstadoHelicoptero estado) {
        this.estado = estado;
    }

    public void setEstadoInicial() {
        if (!(estado instanceof EstadoNormal)) {
            this.estado = new EstadoNormal(this);
        }
    }

}