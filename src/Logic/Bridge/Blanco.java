package Logic.Bridge;

import Logic.Models.Casilla;
import Logic.Models.Ficha;

public class Blanco implements Color{

    @Override
    public void colorearElemento(Ficha ficha) {
    }

    @Override
    public void colorearElemento(Casilla casilla) {
        casilla.setColorGrafico(java.awt.Color.WHITE);
    }
    
}
