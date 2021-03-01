package Interfaces;

import Logic.Carcel;
import Logic.Casilla;
import Logic.Ficha;

public interface Color {

    public void colorearElemento(Ficha ficha);

    public void colorearElemento(Casilla casilla);

    public void colorearElemento(Carcel carcel);

}
