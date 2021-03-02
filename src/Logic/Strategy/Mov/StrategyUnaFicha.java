package Logic.Strategy.Mov;

import Logic.Bridge.*;
import Logic.Models.Casilla;
import java.util.ArrayList;
import Logic.Models.Ficha;
import Logic.Singleton.Partida;
import Utilities.Coordenadas;

public class StrategyUnaFicha implements MovimientoStrategy {

    public void moverObjeto(Casilla posicionFinal, Ficha ficha) {
        int x = posicionFinal.getPosicion().getX();
        int y = posicionFinal.getPosicion().getY();
        ficha.getLblFicha().setLocation(x, y);
        ficha.setCasilla(posicionFinal);

    }

    @Override
    public void moverFichas(ArrayList<Ficha> fichas, int valor1, int valor2) {
        Ficha ficha = fichas.get(0);
        int indiceInicial = Coordenadas.getCoords_tablero().indexOf(ficha.getCasilla());
        int indiceFinal = indiceInicial + (valor1 + valor2);
        int data = verificarLineaDeGanada(valor1, valor2, ficha);

        if (data != 0) {
            if (data != -1) {
                if (ficha.getColor() instanceof Rojo) {
                    Casilla posicionFinal = Coordenadas.getRed_win_lane().get(data);
                    moverObjeto(posicionFinal, ficha);
                } else if (ficha.getColor() instanceof Azul) {
                    Casilla posicionFinal = Coordenadas.getBlue_win_lane().get(data);
                    moverObjeto(posicionFinal, ficha);
                } else if (ficha.getColor() instanceof Amarillo) {
                    Casilla posicionFinal = Coordenadas.getYellow_win_lane().get(data);
                    moverObjeto(posicionFinal, ficha);
                } else {
                    Casilla posicionFinal = Coordenadas.getGreen_win_lane().get(data);
                    moverObjeto(posicionFinal, ficha);
                }
            }
        } else {

            Casilla posicionFinal = Coordenadas.getCoords_tablero().get(indiceFinal);
            moverObjeto(posicionFinal, ficha);
        }

    }

    @Override
    public int verificarLineaDeGanada(int valor1, int valor2, Ficha ficha) {
        int contador = 0;
        boolean contadorWinLane = false;
        for (int i = 1; i <= (valor1 + valor2); i++) {
            Casilla casilla = Coordenadas.getCoords_tablero().get(Coordenadas.getCoords_tablero().indexOf(ficha.getCasilla()) + i);
            if (casilla.getColorGrafico() == ficha.getLblFicha().getColor()) {
                contadorWinLane = true;
                continue;
            }
            if (contadorWinLane) {
                contador++;
            }
        }
        if (contador >= 9) {
            Partida.getInstance().getTurnoActual().getWon().add(ficha);
            return -1;
        }
        return contador;
    }

}
