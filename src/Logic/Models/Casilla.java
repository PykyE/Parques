package Logic.Models;

import Logic.Bridge.Color;
import java.util.ArrayList;

public class Casilla {

    private Color color;
    private boolean estado;
    private ArrayList<Ficha> fichas;

    public Color getColor() {
        return color;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public boolean esSeguro() {
        return estado;
    }

}
