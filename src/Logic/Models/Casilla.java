package Logic.Models;

import Logic.Bridge.*;
import Utilities.Posicion;
import java.util.ArrayList;

public class Casilla {

    private Color color;
    private java.awt.Color colorGrafico;
    private boolean Safe;
    private Posicion posicion;
    private ArrayList<Ficha> fichas = new ArrayList<>();

    public Casilla(Posicion posicion,String nameColor) {
        this.posicion = posicion;
        switch (nameColor) {
            case "Azul": {
                color = new Azul();
                color.colorearElemento(this);
                break;
            }
            case "Rojo": {
                color = new Rojo();
                color.colorearElemento(this);
                break;
            }
            case "Blanca": {
                color = new Blanco();
                color.colorearElemento(this);
                break;
            }
            case "Verde": {
                color = new Verde();
                color.colorearElemento(this);
                break;
            }
            case "Amarillo": {
                color = new Amarillo();
                color.colorearElemento(this);
                break;
            }
        }
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public boolean isSafe() {
        return Safe;
    }
    
    public void setColorGrafico(java.awt.Color colorGrafico){
        this.colorGrafico = colorGrafico;
    }

    public java.awt.Color getColorGrafico() {
        return colorGrafico;
    }
}
