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

    public Casilla(Posicion posicion, String nameColor, boolean safe) {
        this.Safe = safe;
        this.posicion = posicion;
        switch (nameColor) {
            case "Azul": {
                color = new Azul();
                color.colorearElemento(this);
                break;
            }
            case "Roja": {
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

    public void setColorGrafico(java.awt.Color colorGrafico) {
        this.colorGrafico = colorGrafico;
    }

    public java.awt.Color getColorGrafico() {
        return colorGrafico;
    }

    @Override
    public String toString() {
        String retorno = "";
        for (int i = 0; i < fichas.size(); i++) {
            retorno += "Ficha #" + i + ": " + fichas.get(i).getiD() + " y su color es: " + fichas.get(i).getColor().getClass() + "\n";
        }
        return retorno;
    }

}
