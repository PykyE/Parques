package Logic.Strategy.Mov;

import java.util.ArrayList;
import Logic.Models.Ficha;

public interface MovimientoStrategy {

    public void moverFichas(ArrayList<Ficha> fichas, int valor);

}