package Logic.Models;

import GUI.LabelFicha;
import Logic.Bridge.Color;
import Logic.Bridge.Amarillo;
import Logic.Bridge.Azul;
import Logic.Bridge.Rojo;
import Logic.Bridge.Verde;

public class Ficha {

    private int iD;
    private Color color;
    private LabelFicha LblFicha;
    private Casilla casilla;

    public Ficha(java.awt.Color color, int id) {
        iD = id;
        LblFicha = new LabelFicha(id);
        if (color == java.awt.Color.RED) {
            this.color = new Rojo();
            this.color.colorearElemento(this);
        } else if (color == java.awt.Color.BLUE) {
            this.color = new Azul();
            this.color.colorearElemento(this);
        } else if (color == java.awt.Color.GREEN) {
            this.color = new Verde();
            this.color.colorearElemento(this);
        } else {
            this.color = new Amarillo();
            this.color.colorearElemento(this);
        }
    }

    public int getiD() {
        return iD;
    }

    public Color getColor() {
        return color;
    }

    public LabelFicha getLblFicha() {
        return LblFicha;
    }

    public Casilla getCasilla() {
        return casilla;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setCasilla(Casilla casilla) {
        this.casilla = casilla;
    }
    
    

}
