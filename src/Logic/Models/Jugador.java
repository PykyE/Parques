package Logic.Models;

import java.awt.Color;
import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private Color color;
    private ArrayList<Ficha> fichas = new ArrayList<>();
    private ArrayList<Ficha> carcel = new ArrayList<>();
    private ArrayList<Ficha> won = new ArrayList<>();

    public Jugador(String name, Color color) {
        this.nombre = name;
        this.color = color;
        for (int i = 1; i <= 4; i++) {
            Ficha newFicha = new Ficha(color, i);
            fichas.add(newFicha);
            carcel.add(newFicha);
        }
    }

    public int[] tirarDados() {
        int[] retorno = new int[2];
        retorno[0] = Dado.tirar();
        retorno[1] = Dado.tirar();
        return retorno;
    }

    public void sacarFichas() {
        
    }

    public void mover() {

    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public Color getColor() {
        return color;
    }

    public String getNameColor() {
        if (color == java.awt.Color.RED) {
            return "Rojo";
        } else if (color == java.awt.Color.BLUE) {
            return "Azul";
        } else if (color == java.awt.Color.GREEN) {
            return "Verde";
        } else {
            return "Amarillo";
        }
    }

    public ArrayList<Ficha> getCarcel() {
        return carcel;
    }

    public ArrayList<Ficha> getWon() {
        return won;
    }

}
