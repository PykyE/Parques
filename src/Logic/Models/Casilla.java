package Logic.Models;

import Logic.Bridge.Color;
import Utilities.Posicion;
import java.util.ArrayList;

public class Casilla {

    private Color color;
    private boolean Safe;
    private Posicion posicion;
    private ArrayList<Ficha> fichas = new ArrayList<>();

    public Casilla(Posicion posicion) {
        this.posicion = posicion;
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

}
