package com.patrones.helicoptero;

import android.graphics.BitmapFactory;
import com.patrones.laserlightgame.R;
import java.util.Random;


/**
 * Created by suarezch on 22/08/2015.
 */
public class Fabrica {

    // Atributos
    private Random rand;
    // Relaciones
    private PanelJuego panelJuego;


    // Constructor
    public Fabrica(PanelJuego panelJuego) {
        this.rand =  new Random();
        this.panelJuego = panelJuego;
    }

    // Métodos
    public CambiadorEscudo crearCambiadorEscudo() {
        return new CambiadorEscudo(this.panelJuego.WIDTH,(int)(rand.nextDouble()*this.panelJuego.HEIGHT));
    }

    public CambiadorDobleGravedad crearCambiadorDobleGravedad() {
        return new CambiadorDobleGravedad(this.panelJuego.WIDTH,(int)(rand.nextDouble()*this.panelJuego.HEIGHT));
    }

    public Misil crearMisil() {
        return new Misil(BitmapFactory.decodeResource(this.panelJuego.getResources(), R.drawable.
                missile),this.panelJuego.WIDTH, (int)(rand.nextDouble()*this.panelJuego.HEIGHT), this.panelJuego.getHelicoptero().getPuntaje());
    }

    public Humo crearHumo() {
        return new Humo(this.panelJuego.getHelicoptero().getX(),
                this.panelJuego.getHelicoptero().getY());
    }


}
