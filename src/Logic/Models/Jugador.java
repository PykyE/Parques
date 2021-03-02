package Logic.Models;

import Logic.Strategy.Sac.Sacar;
import Logic.Strategy.Mov.Movimiento;
import Logic.Strategy.Mov.StrategyUnaFicha;
import Logic.Strategy.Sac.StrategyCuatroFichas;
import Logic.Strategy.Sac.StrategyDosFichas;
import java.awt.Color;
import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private Color color;
    private int nroIntentos = 0;
    private Movimiento movimiento = new Movimiento();
    private Sacar sacar = new Sacar();
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

    public void sacarFichas(String strat, ArrayList<Ficha> fichas) {
        switch (strat) {
            case "Dos":
                sacar.setStrategy(new StrategyDosFichas());
                sacar.sacarFichas(fichas);
                break;
            case "Cuatro":
                sacar.setStrategy(new StrategyCuatroFichas());
                sacar.sacarFichas(fichas);
                break;
        }
    }

    public void mover(ArrayList<Ficha> fichas, int valor1, int valor2) {
        if (valor2 == 0) {
            movimiento.setStrategy(new StrategyUnaFicha());
            movimiento.moverFicha();
        } else {
            movimiento.setStrategy(new Logic.Strategy.Mov.StrategyDosFichas());
            movimiento.moverFicha();
        }
    }

    public void setNroIntentos(int nroIntentos) {
        this.nroIntentos = nroIntentos;
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

    public int getNroIntentos() {
        return nroIntentos;
    }

}
