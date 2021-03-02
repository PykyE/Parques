package Utilities;

import Logic.Models.Casilla;
import java.util.ArrayList;

public class Coordenadas {

    private static ArrayList<Casilla> coords_tablero = new ArrayList<>();

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
        coords_tablero.add(new Casilla(new Posicion(288, 570)));//1
        coords_tablero.add(new Casilla(new Posicion(363, 570)));//2
        coords_tablero.add(new Casilla(new Posicion(363, 545)));//3
        coords_tablero.add(new Casilla(new Posicion(363, 520)));//4
        coords_tablero.add(new Casilla(new Posicion(363, 495)));//5
        coords_tablero.add(new Casilla(new Posicion(363, 472)));//6 Salida azul
        coords_tablero.add(new Casilla(new Posicion(357, 446)));//7
        coords_tablero.add(new Casilla(new Posicion(362, 416)));//8
        coords_tablero.add(new Casilla(new Posicion(377, 389)));//9
        coords_tablero.add(new Casilla(new Posicion(398, 368)));//10
        coords_tablero.add(new Casilla(new Posicion(413, 360)));//11
        coords_tablero.add(new Casilla(new Posicion(447, 357)));//12
        coords_tablero.add(new Casilla(new Posicion(475, 357)));//13
        coords_tablero.add(new Casilla(new Posicion(499, 357)));//14
        coords_tablero.add(new Casilla(new Posicion(525, 357)));//15
        coords_tablero.add(new Casilla(new Posicion(549, 357)));//16
        coords_tablero.add(new Casilla(new Posicion(574, 357)));//17
        coords_tablero.add(new Casilla(new Posicion(574, 288)));//18
        coords_tablero.add(new Casilla(new Posicion(574, 215)));//19
        coords_tablero.add(new Casilla(new Posicion(547, 215)));//20
        coords_tablero.add(new Casilla(new Posicion(522, 215)));//21
        coords_tablero.add(new Casilla(new Posicion(498, 215)));//22
        coords_tablero.add(new Casilla(new Posicion(474, 215)));//23 Salida verde
        coords_tablero.add(new Casilla(new Posicion(451, 211)));//24
        coords_tablero.add(new Casilla(new Posicion(421, 208)));//25
        coords_tablero.add(new Casilla(new Posicion(394, 204)));//26
        coords_tablero.add(new Casilla(new Posicion(377, 188)));//27
        coords_tablero.add(new Casilla(new Posicion(360, 164)));//28
        coords_tablero.add(new Casilla(new Posicion(358, 135)));//29
        coords_tablero.add(new Casilla(new Posicion(358, 109)));//30
        coords_tablero.add(new Casilla(new Posicion(358, 85)));//31
        coords_tablero.add(new Casilla(new Posicion(358, 60)));//32
        coords_tablero.add(new Casilla(new Posicion(358, 36)));//33
        coords_tablero.add(new Casilla(new Posicion(358, 11)));//34
        coords_tablero.add(new Casilla(new Posicion(288, 11)));//35
        coords_tablero.add(new Casilla(new Posicion(211, 11)));//36
        coords_tablero.add(new Casilla(new Posicion(211, 34)));//37
        coords_tablero.add(new Casilla(new Posicion(211, 61)));//38
        coords_tablero.add(new Casilla(new Posicion(211, 86)));//39
        coords_tablero.add(new Casilla(new Posicion(211, 108)));//40 Salida rojo
        coords_tablero.add(new Casilla(new Posicion(208, 133)));//41
        coords_tablero.add(new Casilla(new Posicion(207, 153)));//42
        coords_tablero.add(new Casilla(new Posicion(201, 173)));//43
        coords_tablero.add(new Casilla(new Posicion(177, 193)));//44
        coords_tablero.add(new Casilla(new Posicion(158, 206)));//45
        coords_tablero.add(new Casilla(new Posicion(134, 206)));//46
        coords_tablero.add(new Casilla(new Posicion(109, 206)));//47
        coords_tablero.add(new Casilla(new Posicion(89, 206)));//48
        coords_tablero.add(new Casilla(new Posicion(62, 206)));//49
        coords_tablero.add(new Casilla(new Posicion(38, 206)));//50
        coords_tablero.add(new Casilla(new Posicion(14, 206)));//51
        coords_tablero.add(new Casilla(new Posicion(14, 284)));//52
        coords_tablero.add(new Casilla(new Posicion(14, 365)));//53
        coords_tablero.add(new Casilla(new Posicion(38, 365)));//54
        coords_tablero.add(new Casilla(new Posicion(61, 365)));//55
        coords_tablero.add(new Casilla(new Posicion(87, 365)));//56
        coords_tablero.add(new Casilla(new Posicion(110, 365)));//57 Salida amarillo
        coords_tablero.add(new Casilla(new Posicion(134, 365)));//58
        coords_tablero.add(new Casilla(new Posicion(156, 371)));//59
        coords_tablero.add(new Casilla(new Posicion(185, 383)));//60
        coords_tablero.add(new Casilla(new Posicion(207, 400)));//61
        coords_tablero.add(new Casilla(new Posicion(219, 421)));//62
        coords_tablero.add(new Casilla(new Posicion(217, 448)));//63
        coords_tablero.add(new Casilla(new Posicion(216, 472)));//64
        coords_tablero.add(new Casilla(new Posicion(216, 495)));//65
        coords_tablero.add(new Casilla(new Posicion(216, 521)));//66
        coords_tablero.add(new Casilla(new Posicion(216, 548)));//67
        coords_tablero.add(new Casilla(new Posicion(216, 569)));//68
    }

    public static void fillRedJail() {
        red_jail.add(new Posicion(30, 30));
        red_jail.add(new Posicion(115, 30));
        red_jail.add(new Posicion(30, 100));
        red_jail.add(new Posicion(115, 100));
    }

    public static void fillGreenJail() {
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

    public static ArrayList<Casilla> getCoords_tablero() {
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
