package Logic;

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
//        fichas.add(new Ficha())
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
    
    public void mover() {
        
    }
    
}
