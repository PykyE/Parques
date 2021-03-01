package Logic;

public class Tablero {

    private static Tablero tablero;

    private Tablero() {

    }

    public static Tablero getInstance() {
        if (tablero == null) {
            tablero = new Tablero();
        }
        return tablero;
    }

}
