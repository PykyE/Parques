package Logic.Bridge;

import Logic.Models.Casilla;
import Logic.Models.Ficha;
import Utilities.Coordenadas;
import java.awt.Point;

public class Amarillo implements Color {

    @Override
    public void colorearElemento(Ficha ficha) {
        ficha.getLblFicha().setColor(java.awt.Color.YELLOW);
        switch (ficha.getiD()) {
            case 1: {
                ficha.getLblFicha().setLocation(new Point(Coordenadas.getYellow_jail().get(0).getX(), Coordenadas.getYellow_jail().get(0).getY()));
                break;
            }
            case 2: {
                ficha.getLblFicha().setLocation(new Point(Coordenadas.getYellow_jail().get(1).getX(), Coordenadas.getYellow_jail().get(1).getY()));
                break;
            }
            case 3: {
                ficha.getLblFicha().setLocation(new Point(Coordenadas.getYellow_jail().get(2).getX(), Coordenadas.getYellow_jail().get(2).getY()));
                break;
            }
            case 4: {
                ficha.getLblFicha().setLocation(new Point(Coordenadas.getYellow_jail().get(3).getX(), Coordenadas.getYellow_jail().get(3).getY()));
                break;
            }
        }
    }

    @Override
    public void colorearElemento(Casilla casilla) {
        casilla.setColorGrafico(java.awt.Color.YELLOW);
    }

}
