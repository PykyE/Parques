package Logic.Strategy.Mov;

import Logic.Models.Ficha;
import java.util.ArrayList;

public class Movimiento {

    private MovimientoStrategy strategy;

    public MovimientoStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(MovimientoStrategy strategy) {
        this.strategy = strategy;
    }

    public void moverFicha(ArrayList<Ficha> fichas, int valor1, int valor2) {
        strategy.moverFichas(fichas, valor1, valor2);
    }

}
