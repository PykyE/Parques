package Logic;

import java.awt.Color;
import java.util.ArrayList;

public class Partida {

    private static Partida instance;

    private Tablero tablero = Tablero.getInstance();
    private ArrayList<Jugador> jugadores = new ArrayList<>();
    private Jugador turnoActual;

    private Partida(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
        turnoActual = jugadores.get(0);
    }

    public static Partida getInstance() {
        if (instance == null) {
            ArrayList<Jugador> newPlayers = new ArrayList<>();
            newPlayers.add(new Jugador("Jugador 1", Color.RED));
            newPlayers.add(new Jugador("Jugador 2", Color.GREEN));
            newPlayers.add(new Jugador("Jugador 3", Color.YELLOW));
            newPlayers.add(new Jugador("Jugador 4", Color.BLUE));
            instance = new Partida(newPlayers);
        }
        return instance;
    }

    public void setTurnoActual(Jugador turnoActual) {
        this.turnoActual = turnoActual;
    }

    public Jugador getTurnoActual() {
        return turnoActual;
    }

}
