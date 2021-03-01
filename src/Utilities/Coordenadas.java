package Utilities;

import java.util.ArrayList;

public class Coordenadas {

    private static ArrayList<Posicion> coords_tablero = new ArrayList<>();

    private static ArrayList<Posicion> red_jail = new ArrayList<>();
    private static ArrayList<Posicion> green_jail = new ArrayList<>();
    private static ArrayList<Posicion> blue_jail = new ArrayList<>();
    private static ArrayList<Posicion> yellow_jail = new ArrayList<>();

    private static ArrayList<Posicion> red_win_lane = new ArrayList<>();
    private static ArrayList<Posicion> green_win_lane = new ArrayList<>();
    private static ArrayList<Posicion> blue_win_lane = new ArrayList<>();
    private static ArrayList<Posicion> yellow_win_lane = new ArrayList<>();

    public static void llenarCoordenadas() {
        coordsTablero();
        fillRedJail();
        fillGreenJail();
        fillBlueJail();
        fillYellowJail();
        fillRedWinLane();
        fillGreenWinLane();
        fillBlueWinLane();
        fillYellowWinLane();
    }

    public static void coordsTablero() {

    }

    public static void fillRedJail() {
        red_jail.add(new Posicion(30, 30));
        red_jail.add(new Posicion(115, 30));
        red_jail.add(new Posicion(30, 100));
        red_jail.add(new Posicion(115, 100));
    }

    public static void fillGreenJail(){
        green_jail.add(new Posicion(450, 30));
        green_jail.add(new Posicion(530, 30));
        green_jail.add(new Posicion(450, 100));
        green_jail.add(new Posicion(530, 100));
    }

    public static void fillBlueJail() {
        blue_jail.add(new Posicion(450, 445));
        blue_jail.add(new Posicion(530, 445));
        blue_jail.add(new Posicion(450, 520));
        blue_jail.add(new Posicion(530, 520));
    }

    public static void fillYellowJail() {
        yellow_jail.add(new Posicion(30, 445));
        yellow_jail.add(new Posicion(115, 445));
        yellow_jail.add(new Posicion(30, 520));
        yellow_jail.add(new Posicion(115, 520));
    }

    public static void fillRedWinLane() {

    }

    public static void fillGreenWinLane() {

    }

    public static void fillBlueWinLane() {

    }

    public static void fillYellowWinLane() {

    }

    public static ArrayList<Posicion> getCoords_tablero() {
        return coords_tablero;
    }

    public static ArrayList<Posicion> getRed_jail() {
        return red_jail;
    }

    public static ArrayList<Posicion> getGreen_jail() {
        return green_jail;
    }

    public static ArrayList<Posicion> getBlue_jail() {
        return blue_jail;
    }

    public static ArrayList<Posicion> getYellow_jail() {
        return yellow_jail;
    }

    public static ArrayList<Posicion> getRed_win_lane() {
        return red_win_lane;
    }

    public static ArrayList<Posicion> getGreen_win_lane() {
        return green_win_lane;
    }

    public static ArrayList<Posicion> getBlue_win_lane() {
        return blue_win_lane;
    }

    public static ArrayList<Posicion> getYellow_win_lane() {
        return yellow_win_lane;
    }

}
