package Logic.Models;

public class Dado {

    public static int tirar() {
        int asd = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        return asd;
    }
}
