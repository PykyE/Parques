package Logic;

public class Partida {

    private static Partida instance;

    private Tablero tablero;

    private Partida() {

    }

    public static Partida getInstance() {
        if (instance == null) {
            instance = new Partida();
        }
        return instance;
    }

}
