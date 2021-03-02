package Utilities;

import Logic.Models.Casilla;
import java.util.ArrayList;

public class Coordenadas {

    private static ArrayList<Casilla> coords_tablero = new ArrayList<>();

    private static ArrayList<Posicion> red_jail = new ArrayList<>();
    private static ArrayList<Posicion> green_jail = new ArrayList<>();
    private static ArrayList<Posicion> blue_jail = new ArrayList<>();
    private static ArrayList<Posicion> yellow_jail = new ArrayList<>();

    private static ArrayList<Casilla> red_win_lane = new ArrayList<>();
    private static ArrayList<Casilla> green_win_lane = new ArrayList<>();
    private static ArrayList<Casilla> blue_win_lane = new ArrayList<>();
    private static ArrayList<Casilla> yellow_win_lane = new ArrayList<>();

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
        coords_tablero.add(new Casilla(new Posicion(285,568),"Azul"));//1
        coords_tablero.add(new Casilla(new Posicion(366,569),"Blanca"));//2
        coords_tablero.add(new Casilla(new Posicion(368,544),"Blanca"));//3
        coords_tablero.add(new Casilla(new Posicion(368,519),"Blanca"));//4
        coords_tablero.add(new Casilla(new Posicion(369,495),"Blanca"));//5
        coords_tablero.add(new Casilla(new Posicion(368,471),"Blanco"));//6 Salida azul
        coords_tablero.add(new Casilla(new Posicion(355,447),"Blanca"));//7
        coords_tablero.add(new Casilla(new Posicion(356,417),"Blanca"));//8
        coords_tablero.add(new Casilla(new Posicion(369,392),"Blanca"));//9
        coords_tablero.add(new Casilla(new Posicion(388,370),"Blanca"));//10
        coords_tablero.add(new Casilla(new Posicion(411,355),"Blanca"));//11
        coords_tablero.add(new Casilla(new Posicion(440,346),"Blanca"));//12
        coords_tablero.add(new Casilla(new Posicion(472,348),"Blanca"));//13
        coords_tablero.add(new Casilla(new Posicion(497,362),"Blanca"));//14
        coords_tablero.add(new Casilla(new Posicion(521,365),"Blanca"));//15
        coords_tablero.add(new Casilla(new Posicion(545,368),"Blanca"));//16
        coords_tablero.add(new Casilla(new Posicion(568,367),"Blanca"));//17
        coords_tablero.add(new Casilla(new Posicion(571,287),"Verde"));//18
        coords_tablero.add(new Casilla(new Posicion(570,212),"Blanca"));//19
        coords_tablero.add(new Casilla(new Posicion(544,216),"Blanca"));//20
        coords_tablero.add(new Casilla(new Posicion(520,215),"Blanca"));//21
        coords_tablero.add(new Casilla(new Posicion(496,212),"Blanca"));//22
        coords_tablero.add(new Casilla(new Posicion(472,215),"Blanca"));//23 Salida verde
        coords_tablero.add(new Casilla(new Posicion(444,234),"Blanca"));//24
        coords_tablero.add(new Casilla(new Posicion(416,231),"Blanca"));//25
        coords_tablero.add(new Casilla(new Posicion(381,216),"Blanca"));//26
        coords_tablero.add(new Casilla(new Posicion(368,190),"Blanca"));//27
        coords_tablero.add(new Casilla(new Posicion(350,162),"Blanca"));//28
        coords_tablero.add(new Casilla(new Posicion(349,136),"Blanca"));//29
        coords_tablero.add(new Casilla(new Posicion(364,111),"Blanca"));//30
        coords_tablero.add(new Casilla(new Posicion(358,84),"Blanca"));//31
        coords_tablero.add(new Casilla(new Posicion(355,60),"Blanca"));//32
        coords_tablero.add(new Casilla(new Posicion(362,36),"Blanca"));//33
        coords_tablero.add(new Casilla(new Posicion(360,12),"Blanca"));//34
        coords_tablero.add(new Casilla(new Posicion(285,12),"Roja"));//35
        coords_tablero.add(new Casilla(new Posicion(206,12),"Blanca"));//36
        coords_tablero.add(new Casilla(new Posicion(206,36),"Blanca"));//37
        coords_tablero.add(new Casilla(new Posicion(208,60),"Blanca"));//38
        coords_tablero.add(new Casilla(new Posicion(211,83),"Blanca"));//39
        coords_tablero.add(new Casilla(new Posicion(207,108),"Blanca"));//40 Salida rojo
        coords_tablero.add(new Casilla(new Posicion(224,136),"Blanca"));//41
        coords_tablero.add(new Casilla(new Posicion(222,161),"Blanca"));//42
        coords_tablero.add(new Casilla(new Posicion(209,190),"Blanca"));//43
        coords_tablero.add(new Casilla(new Posicion(193,208),"Blanca"));//44
        coords_tablero.add(new Casilla(new Posicion(162,212),"Blanca"));//45
        coords_tablero.add(new Casilla(new Posicion(134,219),"Blanca"));//46
        coords_tablero.add(new Casilla(new Posicion(110,207),"Blanca"));//47
        coords_tablero.add(new Casilla(new Posicion(83,210),"Blanca"));//48
        coords_tablero.add(new Casilla(new Posicion(60,216),"Blanca"));//49
        coords_tablero.add(new Casilla(new Posicion(34,220),"Blanca"));//50
        coords_tablero.add(new Casilla(new Posicion(10,214),"Blanca"));//51
        coords_tablero.add(new Casilla(new Posicion(12,285),"Amarillo"));//52
        coords_tablero.add(new Casilla(new Posicion(11,366),"Blanca"));//53
        coords_tablero.add(new Casilla(new Posicion(35,367),"Blanca"));//54
        coords_tablero.add(new Casilla(new Posicion(59,371),"Blanca"));//55
        coords_tablero.add(new Casilla(new Posicion(84,370),"Blanca"));//56
        coords_tablero.add(new Casilla(new Posicion(108,372),"Blanca"));//57 Salida amarillo
        coords_tablero.add(new Casilla(new Posicion(132,353),"Blanca"));//58
        coords_tablero.add(new Casilla(new Posicion(160,354),"Blanca"));//59
        coords_tablero.add(new Casilla(new Posicion(188,375),"Blanca"));//60
        coords_tablero.add(new Casilla(new Posicion(206,395),"Blanca"));//61
        coords_tablero.add(new Casilla(new Posicion(225,412),"Blanca"));//62
        coords_tablero.add(new Casilla(new Posicion(229,446),"Blanca"));//63
        coords_tablero.add(new Casilla(new Posicion(202,471),"Blanca"));//64
        coords_tablero.add(new Casilla(new Posicion(210,493),"Blanca"));//65
        coords_tablero.add(new Casilla(new Posicion(209,519),"Blanca"));//66
        coords_tablero.add(new Casilla(new Posicion(213,543),"Blanca"));//67
        coords_tablero.add(new Casilla(new Posicion(207,567),"Blanca"));//68*/
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
        red_win_lane.add(new Casilla(new Posicion(303,48),"Blanca"));
        red_win_lane.add(new Casilla(new Posicion(302,67),"Blanca"));
        red_win_lane.add(new Casilla(new Posicion(301,96),"Blanca"));
        red_win_lane.add(new Casilla(new Posicion(305,118),"Blanca"));
        red_win_lane.add(new Casilla(new Posicion(301,144),"Blanca"));
        red_win_lane.add(new Casilla(new Posicion(303,171),"Blanca"));
        red_win_lane.add(new Casilla(new Posicion(303,197),"Blanca"));
    }

    public static void fillGreenWinLane() {
        green_win_lane.add(new Casilla(new Posicion(557,293),"Blanca"));
        green_win_lane.add(new Casilla(new Posicion(534,291),"Blanca"));
        green_win_lane.add(new Casilla(new Posicion(506,291),"Blanca"));
        green_win_lane.add(new Casilla(new Posicion(483,305),"Blanca"));
        green_win_lane.add(new Casilla(new Posicion(463,293),"Blanca"));
        green_win_lane.add(new Casilla(new Posicion(432,293),"Blanca"));
        green_win_lane.add(new Casilla(new Posicion(409,304),"Blanca"));
    }

    public static void fillBlueWinLane() {
        blue_win_lane.add(new Casilla(new Posicion(305,556),"Blanca"));
        blue_win_lane.add(new Casilla(new Posicion(289,534),"Blanca"));
        blue_win_lane.add(new Casilla(new Posicion(285,510),"Blanca"));
        blue_win_lane.add(new Casilla(new Posicion(278,484),"Blanca"));
        blue_win_lane.add(new Casilla(new Posicion(312,455),"Blanca"));
        blue_win_lane.add(new Casilla(new Posicion(304,429),"Blanca"));
        blue_win_lane.add(new Casilla(new Posicion(300,405),"Blanca"));
    }

    public static void fillYellowWinLane() {
        yellow_win_lane.add(new Casilla(new Posicion(47,291),"Blanca"));
        yellow_win_lane.add(new Casilla(new Posicion(67,293),"Blanca"));
        yellow_win_lane.add(new Casilla(new Posicion(97,301),"Blanca"));
        yellow_win_lane.add(new Casilla(new Posicion(120,315),"Blanca"));
        yellow_win_lane.add(new Casilla(new Posicion(149,298),"Blanca"));
        yellow_win_lane.add(new Casilla(new Posicion(170,291),"Blanca"));
        yellow_win_lane.add(new Casilla(new Posicion(195,296),"Blanca"));

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

    public static ArrayList<Casilla> getRed_win_lane() {
        return red_win_lane;
    }

    public static ArrayList<Casilla> getGreen_win_lane() {
        return green_win_lane;
    }

    public static ArrayList<Casilla> getBlue_win_lane() {
        return blue_win_lane;
    }

    public static ArrayList<Casilla> getYellow_win_lane() {
        return yellow_win_lane;
    }

}
