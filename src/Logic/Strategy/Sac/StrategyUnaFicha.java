package Logic.Strategy.Sac;

import Logic.Bridge.Azul;
import Logic.Bridge.Rojo;
import Logic.Bridge.Verde;
import java.util.ArrayList;
import Logic.Models.Ficha;
import Logic.Models.Jugador;
import Logic.Singleton.Partida;
import Utilities.Coordenadas;
import java.awt.Point;

public class StrategyUnaFicha implements SacarStrategy {

    @Override
    public void sacarFichas(ArrayList<Ficha> fichas) {
        Jugador actualPlayer = Partida.getInstance().getTurnoActual();
        ArrayList<Ficha> carcel = actualPlayer.getCarcel();
        Ficha ficha = fichas.get(0);
        carcel.remove(ficha);
        if (ficha.getColor() instanceof Rojo) {
            ficha.getLblFicha().setLocation(new Point(Coordenadas.getCoords_tablero().get(39).getPosicion().getX(), Coordenadas.getCoords_tablero().get(39).getPosicion().getY()));
            Coordenadas.getCoords_tablero().get(39).getFichas().add(ficha);
            ficha.setCasilla(Coordenadas.getCoords_tablero().get(39));
        } else if (ficha.getColor() instanceof Azul) {
            ficha.getLblFicha().setLocation(new Point(Coordenadas.getCoords_tablero().get(5).getPosicion().getX(), Coordenadas.getCoords_tablero().get(5).getPosicion().getY()));
            Coordenadas.getCoords_tablero().get(5).getFichas().add(ficha);
            ficha.setCasilla(Coordenadas.getCoords_tablero().get(5));

        } else if (ficha.getColor() instanceof Verde) {
            ficha.getLblFicha().setLocation(new Point(Coordenadas.getCoords_tablero().get(22).getPosicion().getX(), Coordenadas.getCoords_tablero().get(22).getPosicion().getY()));
            Coordenadas.getCoords_tablero().get(22).getFichas().add(ficha);
            ficha.setCasilla(Coordenadas.getCoords_tablero().get(22));

        } else {
            ficha.getLblFicha().setLocation(new Point(Coordenadas.getCoords_tablero().get(56).getPosicion().getX(), Coordenadas.getCoords_tablero().get(56).getPosicion().getY()));
            Coordenadas.getCoords_tablero().get(56).getFichas().add(ficha);
            ficha.setCasilla(Coordenadas.getCoords_tablero().get(56));

        }
    }

}
