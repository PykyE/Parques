package Logic.Models;

import java.awt.Color;
import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private Color color;
    private int score;
    private ArrayList<Ficha> fichas = new ArrayList<>();

    public Jugador(String name, Color color) {
        this.nombre = name;
        this.color = color;
        for (int i = 1; i <= 4; i++) {
            Ficha newFicha = new Ficha(color,i);
            fichas.add(newFicha);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getScore() {
        return score;
    }

    public int[] tirarDados() {
        int[] retorno = new int[2];
        retorno[0] = Dado.tirar();
        retorno[1] = Dado.tirar();
        return retorno;
    }

    public ArrayList<Ficha> getFichas() {
        return fichas;
    }

    public void mover() {

    }

}
