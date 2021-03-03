package Logic.Strategy.Mov;

import Logic.Bridge.Amarillo;
import Logic.Bridge.Azul;
import Logic.Bridge.Rojo;
import Logic.Models.Casilla;
import java.util.ArrayList;
import Logic.Models.Ficha;
import Logic.Singleton.Partida;
import Utilities.Coordenadas;

public class StrategyDosFichas implements MovimientoStrategy {

    public void moverObjeto(Casilla posicionFinal, Ficha ficha) {
        int x = posicionFinal.getPosicion().getX();
        int y = posicionFinal.getPosicion().getY();
        ficha.getLblFicha().setLocation(x, y);
        ficha.setCasilla(posicionFinal);
        posicionFinal.getFichas().add(ficha);
    }

    @Override
    public void moverFichas(ArrayList<Ficha> fichas, int valor1, int valor2) {
        Ficha fichaUno = fichas.get(0);
        Ficha fichaDos = fichas.get(1);

        int dataUno = verificarLineaDeGanada(valor1, valor2, fichaUno);
        int dataDos = verificarLineaDeGanada(valor1, valor2, fichaDos);

        int indiceInicialUno = Coordenadas.getCoords_tablero().indexOf(fichaUno.getCasilla());
        int indicieInicialDos = Coordenadas.getCoords_tablero().indexOf(fichaDos.getCasilla());

        int indiceFinalUno = (indiceInicialUno + valor1);
        int indiceFinalDos = (indicieInicialDos + valor2);

        if (dataUno != 0) {
            if (dataUno != -1) {
                if (fichaUno.getColor() instanceof Rojo) {
                    Casilla posicionFinal = Coordenadas.getRed_win_lane().get(dataUno);
                    moverObjeto(posicionFinal, fichaUno);
                } else if (fichaUno.getColor() instanceof Azul) {
                    Casilla posicionFinal = Coordenadas.getBlue_win_lane().get(dataUno);
                    moverObjeto(posicionFinal, fichaUno);
                } else if (fichaUno.getColor() instanceof Amarillo) {
                    Casilla posicionFinal = Coordenadas.getYellow_win_lane().get(dataUno);
                    moverObjeto(posicionFinal, fichaUno);
                } else {
                    Casilla posicionFinal = Coordenadas.getGreen_win_lane().get(dataUno);
                    moverObjeto(posicionFinal, fichaUno);
                }
            }

        } else {
            Casilla posicionFinal = Coordenadas.getCoords_tablero().get(indiceFinalUno);
            if (!posicionFinal.getFichas().isEmpty() && !posicionFinal.isSafe()) {
                posicionFinal.getFichas().forEach((f) -> {
                    if (f.getLblFicha().getColor() != fichaUno.getLblFicha().getColor()) {
                        f.getColor().colorearElemento(f);
                        Partida.getInstance().getJugadores().forEach((player) -> {
                            if (player.getColor() == f.getLblFicha().getColor()) {
                                player.getCarcel().add(f);
                            }
                        });
                    }
                });
            }
            moverObjeto(posicionFinal, fichaUno);
        }

        if (dataDos != 0) {
            if (dataDos != -1) {
                if (fichaDos.getColor() instanceof Rojo) {
                    Casilla posicionFinal = Coordenadas.getRed_win_lane().get(dataDos);
                    moverObjeto(posicionFinal, fichaDos);
                } else if (fichaDos.getColor() instanceof Azul) {
                    Casilla posicionFinal = Coordenadas.getBlue_win_lane().get(dataDos);
                    moverObjeto(posicionFinal, fichaDos);
                } else if (fichaDos.getColor() instanceof Amarillo) {
                    Casilla posicionFinal = Coordenadas.getYellow_win_lane().get(dataDos);
                    moverObjeto(posicionFinal, fichaDos);
                } else {
                    Casilla posicionFinal = Coordenadas.getGreen_win_lane().get(dataDos);
                    moverObjeto(posicionFinal, fichaDos);
                }
            }
        } else {
            Casilla posicionFinal = Coordenadas.getCoords_tablero().get(indiceFinalDos);
            if (!posicionFinal.getFichas().isEmpty() && !posicionFinal.isSafe()) {
                posicionFinal.getFichas().forEach((f) -> {
                    if (f.getLblFicha().getColor() != fichaDos.getLblFicha().getColor()) {
                        f.getColor().colorearElemento(f);
                        Partida.getInstance().getJugadores().forEach((player) -> {
                            if (player.getColor() == f.getLblFicha().getColor()) {
                                player.getCarcel().add(f);
                            }
                        });
                    }
                });
            }
            moverObjeto(posicionFinal, fichaDos);
        }

    }

    @Override
    public int verificarLineaDeGanada(int valor1, int valor2, Ficha ficha) {
        int contador = 0;
        boolean contadorWinLane = false;
        Casilla casilla;
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
            return -1;
        }
        return contador;
    }

}
