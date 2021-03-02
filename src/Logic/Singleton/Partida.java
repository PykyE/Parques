package Logic.Singleton;

import Logic.Models.Jugador;
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
            newPlayers.add(new Jugador("Jugador 3", Color.BLUE));
            newPlayers.add(new Jugador("Jugador 4", Color.YELLOW));
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

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    
    public void setSiguienteJugador(){
        int pos = jugadores.indexOf(turnoActual);
        if((pos) == 3){
            turnoActual = jugadores.get(0);
        }else{
            turnoActual = jugadores.get(pos+1);
        }
    }

}
