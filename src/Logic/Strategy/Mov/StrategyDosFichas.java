package Logic.Strategy.Mov;

import Logic.Bridge.Amarillo;
import Logic.Bridge.Azul;
import Logic.Bridge.Rojo;
import Logic.Models.Casilla;
import java.util.ArrayList;
import Logic.Models.Ficha;
import Logic.Models.Jugador;
import Logic.Singleton.Partida;
import Utilities.Coordenadas;

public class StrategyDosFichas implements MovimientoStrategy {

    public void moverObjeto(Casilla posicionFinal, Ficha ficha) {
        int x = posicionFinal.getPosicion().getX();
        int y = posicionFinal.getPosicion().getY();
        ficha.getCasilla().getFichas().remove(ficha);
        ficha.getLblFicha().setLocation(x, y);
        ficha.setCasilla(posicionFinal);
        posicionFinal.getFichas().add(ficha);
    }

    @Override
    public void moverFichas(ArrayList<Ficha> fichas, int valor1, int valor2) {

        Ficha fichaUno = fichas.get(0);
        Ficha fichaDos = fichas.get(1);

        Jugador playerRef = null;
        for (int i = 0; i < Partida.getInstance().getJugadores().size(); i++) {
            if (Partida.getInstance().getJugadores().get(i).getColor() == fichaUno.getLblFicha().getColor()) {
                playerRef = Partida.getInstance().getJugadores().get(i);
            }
        }

        int dataUno = verificarLineaDeGanada(valor1, 0, fichaUno);
        int dataDos = verificarLineaDeGanada(0, valor2, fichaDos);

        int indiceInicialUno = Coordenadas.getCoords_tablero().indexOf(fichaUno.getCasilla());
        int indicieInicialDos = Coordenadas.getCoords_tablero().indexOf(fichaDos.getCasilla());

        int indiceFinalUno = (indiceInicialUno + valor1);
        int indiceFinalDos = (indicieInicialDos + valor2);

        //Ficha Uno
        if (Coordenadas.getRed_win_lane().contains(fichaUno.getCasilla())
                || Coordenadas.getBlue_win_lane().contains(fichaUno.getCasilla())
                || Coordenadas.getGreen_win_lane().contains(fichaUno.getCasilla())
                || Coordenadas.getYellow_win_lane().contains(fichaUno.getCasilla())) {
            if (fichaUno.getColor() instanceof Rojo) {
                indiceInicialUno = Coordenadas.getRed_win_lane().indexOf(fichaUno.getCasilla());
                dataUno = indiceInicialUno + valor1;
                Casilla posicionFinal;
                if (dataUno >= 7) {
                    Partida.getInstance().getTurnoActual().getWon().add(fichaUno);
                    fichaUno.getLblFicha().setVisible(false);
                    fichaUno.getCasilla().getFichas().remove(fichaUno);
                } else {
                    posicionFinal = Coordenadas.getRed_win_lane().get(dataUno);
                    moverObjeto(posicionFinal, fichaUno);
                }
            } else if (fichaUno.getColor() instanceof Azul) {
                indiceInicialUno = Coordenadas.getBlue_win_lane().indexOf(fichaUno.getCasilla());
                dataUno = indiceInicialUno + valor1;
                Casilla posicionFinal;
                if (dataUno >= 7) {
                    Partida.getInstance().getTurnoActual().getWon().add(fichaUno);
                    fichaUno.getLblFicha().setVisible(false);
                    fichaUno.getCasilla().getFichas().remove(fichaUno);
                } else {
                    posicionFinal = Coordenadas.getBlue_win_lane().get(dataUno);
                    moverObjeto(posicionFinal, fichaUno);
                }
            } else if (fichaUno.getColor() instanceof Amarillo) {
                indiceInicialUno = Coordenadas.getYellow_win_lane().indexOf(fichaUno.getCasilla());
                dataUno = indiceInicialUno + valor1;
                Casilla posicionFinal;
                if (dataUno >= 7) {
                    Partida.getInstance().getTurnoActual().getWon().add(fichaUno);
                    fichaUno.getLblFicha().setVisible(false);
                    fichaUno.getCasilla().getFichas().remove(fichaUno);
                } else {
                    posicionFinal = Coordenadas.getYellow_win_lane().get(dataUno);
                    moverObjeto(posicionFinal, fichaUno);
                }
            } else {
                indiceInicialUno = Coordenadas.getGreen_win_lane().indexOf(fichaUno.getCasilla());
                dataUno = indiceInicialUno + valor1;
                Casilla posicionFinal;
                if (dataUno >= 7) {
                    Partida.getInstance().getTurnoActual().getWon().add(fichaUno);
                    fichaUno.getLblFicha().setVisible(false);
                    fichaUno.getCasilla().getFichas().remove(fichaUno);
                } else {
                    posicionFinal = Coordenadas.getGreen_win_lane().get(dataUno);
                    moverObjeto(posicionFinal, fichaUno);
                }
            }
        } else {
            indiceInicialUno = Coordenadas.getCoords_tablero().indexOf(fichaUno.getCasilla());
            indiceFinalUno = (indiceInicialUno + (valor1) >= 68) ? indiceInicialUno + valor1 - 68 : indiceInicialUno + valor1;
            dataUno = verificarLineaDeGanada(valor1, 0, fichaUno);
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
                ArrayList<Ficha> fichasRemove = new ArrayList<>();
                if (!posicionFinal.getFichas().isEmpty() && !posicionFinal.isSafe()) {
                    posicionFinal.getFichas().forEach((f) -> {
                        if (f.getLblFicha().getColor() != fichaUno.getLblFicha().getColor()) {
                            f.getColor().colorearElemento(f);
                            Partida.getInstance().getJugadores().forEach((player) -> {
                                if (player.getColor() == f.getLblFicha().getColor()) {
                                    fichasRemove.add(f);
                                    player.getCarcel().add(f);
                                }
                            });
                        }
                    });
                    fichasRemove.forEach((ficha) -> {
                        ficha.getCasilla().getFichas().remove(ficha);
                    });
                }
                moverObjeto(posicionFinal, fichaUno);
            }
        }

        //Ficha dos
        if ((Coordenadas.getRed_win_lane().contains(fichaDos.getCasilla())
                || Coordenadas.getBlue_win_lane().contains(fichaDos.getCasilla())
                || Coordenadas.getGreen_win_lane().contains(fichaDos.getCasilla())
                || Coordenadas.getYellow_win_lane().contains(fichaDos.getCasilla()))) {
            if (fichaDos.getColor() instanceof Rojo) {
                indicieInicialDos = Coordenadas.getRed_win_lane().indexOf(fichaDos.getCasilla());
                dataDos = indicieInicialDos + valor2;
                Casilla posicionFinal;
                if (dataDos >= 7) {
                    Partida.getInstance().getTurnoActual().getWon().add(fichaDos);
                    fichaDos.getLblFicha().setVisible(false);
                    fichaDos.getCasilla().getFichas().remove(fichaUno);
                } else {
                    posicionFinal = Coordenadas.getRed_win_lane().get(dataDos);
                    moverObjeto(posicionFinal, fichaDos);
                }
            } else if (fichaDos.getColor() instanceof Azul) {
                indicieInicialDos = Coordenadas.getBlue_win_lane().indexOf(fichaDos.getCasilla());
                dataDos = indicieInicialDos + valor2;
                Casilla posicionFinal;
                if (dataDos >= 7) {
                    Partida.getInstance().getTurnoActual().getWon().add(fichaDos);
                    fichaDos.getLblFicha().setVisible(false);
                    fichaDos.getCasilla().getFichas().remove(fichaUno);
                } else {
                    posicionFinal = Coordenadas.getBlue_win_lane().get(dataDos);
                    moverObjeto(posicionFinal, fichaDos);
                }
            } else if (fichaDos.getColor() instanceof Amarillo) {
                indicieInicialDos = Coordenadas.getYellow_win_lane().indexOf(fichaDos.getCasilla());
                dataDos = indicieInicialDos + valor2;
                Casilla posicionFinal;
                if (dataDos >= 7) {
                    Partida.getInstance().getTurnoActual().getWon().add(fichaDos);
                    fichaDos.getLblFicha().setVisible(false);
                    fichaDos.getCasilla().getFichas().remove(fichaUno);
                } else {
                    posicionFinal = Coordenadas.getYellow_win_lane().get(dataDos);
                    moverObjeto(posicionFinal, fichaDos);
                }
            } else {
                indicieInicialDos = Coordenadas.getGreen_win_lane().indexOf(fichaDos.getCasilla());
                dataDos = indicieInicialDos + valor2;
                Casilla posicionFinal;
                if (dataDos >= 7) {
                    Partida.getInstance().getTurnoActual().getWon().add(fichaDos);
                    fichaDos.getLblFicha().setVisible(false);
                    fichaDos.getCasilla().getFichas().remove(fichaUno);
                } else {
                    posicionFinal = Coordenadas.getGreen_win_lane().get(dataDos);
                    moverObjeto(posicionFinal, fichaDos);
                }
            }
        } else {
            indicieInicialDos = Coordenadas.getCoords_tablero().indexOf(fichaDos.getCasilla());
            indiceFinalDos = (indicieInicialDos + (valor2) >= 68) ? indicieInicialDos + valor2 - 68 : indicieInicialDos + valor2;
            dataDos = verificarLineaDeGanada(0, valor2, fichaDos);
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
                ArrayList<Ficha> fichasRemove = new ArrayList<>();
                if (!posicionFinal.getFichas().isEmpty() && !posicionFinal.isSafe()) {
                    posicionFinal.getFichas().forEach((f) -> {
                        if (f.getLblFicha().getColor() != fichaDos.getLblFicha().getColor()) {
                            f.getColor().colorearElemento(f);
                            Partida.getInstance().getJugadores().forEach((player) -> {
                                if (player.getColor() == f.getLblFicha().getColor()) {
                                    fichasRemove.add(f);
                                    player.getCarcel().add(f);
                                }
                            });
                        }
                    });
                    fichasRemove.forEach((fichaxd) -> {
                        fichaxd.getCasilla().getFichas().remove(fichaxd);
                    });
                }
                moverObjeto(posicionFinal, fichaDos);
            }
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
        if (contador >= 7) {
            Partida.getInstance().getTurnoActual().getWon().add(ficha);
            ficha.getCasilla().getFichas().remove(ficha);
            ficha.getLblFicha().setVisible(false);
            return -1;
        }
        return contador;
    }

}
