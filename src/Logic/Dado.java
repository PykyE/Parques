package Logic;

public class Dado {

    public int tirar() {
        return (int) Math.floor(Math.random()*(7)+1);
    }
}
