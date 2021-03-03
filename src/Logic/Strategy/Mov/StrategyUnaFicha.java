package Logic.Strategy.Mov;

import Logic.Bridge.*;
import Logic.Models.Casilla;
import java.util.ArrayList;
import Logic.Models.Ficha;
import Logic.Models.Jugador;
import Logic.Singleton.Partida;
import Utilities.Coordenadas;

public class StrategyUnaFicha implements MovimientoStrategy {

    public void moverObjeto(Casilla posicionFinal, Ficha ficha) {
        int x = posicionFinal.getPosicion().getX();
        int y = posicionFinal.getPosicion().getY();
        ficha.getLblFicha().setLocation(x, y);
        ficha.setCasilla(posicionFinal);
        posicionFinal.getFichas().add(ficha);
    }

    @Override
    public void moverFichas(ArrayList<Ficha> fichas, int valor1, int valor2) {
        Ficha ficha = fichas.get(0);
        Jugador playerRef = null;
        for (int i = 0; i < Partida.getInstance().getJugadores().size(); i++) {
            if (Partida.getInstance().getJugadores().get(i).getColor() == ficha.getLblFicha().getColor()) {
                playerRef = Partida.getInstance().getJugadores().get(i);
            }
        }

        if (playerRef.getWon().contains(ficha)) {
            int indiceInicial;
            int data;
            if (ficha.getColor() instanceof Rojo) {
                indiceInicial = Coordenadas.getRed_win_lane().indexOf(ficha.getCasilla());
                data = indiceInicial + valor1 + valor2;
                Casilla posicionFinal = Coordenadas.getRed_win_lane().get(data);
                if (data >= 8) {
                    Partida.getInstance().getTurnoActual().getWon().add(ficha);
                    ficha.getLblFicha().setVisible(false);
                    posicionFinal.getFichas().remove(ficha);
                } else {
                    moverObjeto(posicionFinal, ficha);
                }
            } else if (ficha.getColor() instanceof Azul) {
                indiceInicial = Coordenadas.getBlue_win_lane().indexOf(ficha.getCasilla());
                data = indiceInicial + valor1 + valor2;
                Casilla posicionFinal = Coordenadas.getBlue_win_lane().get(data);
                if (data >= 8) {
                    Partida.getInstance().getTurnoActual().getWon().add(ficha);
                    ficha.getLblFicha().setVisible(false);
                    posicionFinal.getFichas().remove(ficha);
                } else {
                    moverObjeto(posicionFinal, ficha);
                }
            } else if (ficha.getColor() instanceof Amarillo) {
                indiceInicial = Coordenadas.getYellow_win_lane().indexOf(ficha.getCasilla());
                data = indiceInicial + valor1 + valor2;
                Casilla posicionFinal = Coordenadas.getYellow_win_lane().get(data);
                if (data >= 8) {
                    Partida.getInstance().getTurnoActual().getWon().add(ficha);
                    ficha.getLblFicha().setVisible(false);
                    posicionFinal.getFichas().remove(ficha);
                } else {
                    moverObjeto(posicionFinal, ficha);
                }
            } else {
                indiceInicial = Coordenadas.getGreen_win_lane().indexOf(ficha.getCasilla());
                data = indiceInicial + valor1 + valor2;
                Casilla posicionFinal = Coordenadas.getGreen_win_lane().get(data);
                if (data >= 8) {
                    Partida.getInstance().getTurnoActual().getWon().add(ficha);
                    ficha.getLblFicha().setVisible(false);
                    posicionFinal.getFichas().remove(ficha);
                } else {
                    moverObjeto(posicionFinal, ficha);
                }
            }
        } else {
            int indiceInicial = Coordenadas.getCoords_tablero().indexOf(ficha.getCasilla());
            int indiceFinal = (indiceInicial + (valor1 + valor2) >= 68) ? indiceInicial + valor1 + valor2 - 68 : indiceInicial + valor1 + valor2;
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
                if (!posicionFinal.getFichas().isEmpty() && !posicionFinal.isSafe()) {
                    posicionFinal.getFichas().forEach((f) -> {
                        if (f.getLblFicha().getColor() != ficha.getLblFicha().getColor()) {
                            f.getColor().colorearElemento(f);
                            Partida.getInstance().getJugadores().forEach((player) -> {
                                if (player.getColor() == f.getLblFicha().getColor()) {
                                    player.getCarcel().add(f);
                                }
                            });
                        }
                    });
                }
                moverObjeto(posicionFinal, ficha);
            }
        }

    }

    @Override
    public int verificarLineaDeGanada(int valor1, int valor2, Ficha ficha) {
        int contador = 0;
        boolean contadorWinLane = false;
        Casilla casilla = null;
        Casilla copia = ficha.getCasilla();
        for (int i = 1; i <= (valor1 + valor2); i++) {
            casilla = copia;
            int suma = Coordenadas.getCoords_tablero().indexOf(casilla) + i;
            if (suma >= 68) {
                casilla = Coordenadas.getCoords_tablero().get(suma - 68);
            } else {
                casilla = Coordenadas.getCoords_tablero().get(suma);
            }

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
            ficha.getLblFicha().setVisible(false);
            casilla.getFichas().remove(ficha);
            return -1;
        }
        return contador;
    }

}
