package Logic.Strategy.Sac;

import Logic.Bridge.Rojo;
import java.util.ArrayList;
import Logic.Models.Ficha;
import Logic.Models.Jugador;
import Logic.Singleton.Partida;
import Utilities.Coordenadas;
import java.awt.Point;

public class StrategyCuatroFichas implements SacarStrategy {

    @Override
    public void sacarFichas(ArrayList<Ficha> fichas) {
        Jugador actualPlayer = Partida.getInstance().getTurnoActual();
        ArrayList carcel = actualPlayer.getCarcel();
        fichas.forEach((ficha) -> {
            carcel.remove(ficha);
            if (ficha.getColor() instanceof Rojo) {
                ficha.getLblFicha().setLocation(new Point(Coordenadas.getCoords_tablero().get(0).getX(), Coordenadas.getCoords_tablero().get(0).getY()));
            } else if (ficha.getColor() instanceof Rojo) {

            } else if (ficha.getColor() instanceof Rojo) {

            } else {

            }
        });
    }

}
