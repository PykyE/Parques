package Logic.Strategy.Sac;

import Logic.Models.Ficha;
import java.util.ArrayList;

public class Sacar {

    private SacarStrategy strategy;

    public SacarStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(SacarStrategy strategy) {
        this.strategy = strategy;
    }

    public void sacarFichas(ArrayList<Ficha> fichas) {
        strategy.sacarFichas(fichas);
    }

}
