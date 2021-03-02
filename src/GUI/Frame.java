package GUI;

import Logic.Singleton.Partida;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import javax.swing.JFrame;

public class Frame extends JFrame {

    private final int ancho = 925;
    private final int alto = 648;

    private PanelTablero P_tablero;
    private PanelControles P_controles;

    private Partida partida;

    public Frame() {
        initTemplate();
    }

    public void initTemplate() {
        setLayout(null);
        setTitle("Parchis");
        setSize(new Dimension(ancho, alto));
        getContentPane().setBackground(new Color(153, 76, 0));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents() {
        P_tablero = new PanelTablero();
        P_tablero.setLocation(new Point(5, 5));
        add(P_tablero);

        P_controles = new PanelControles(this);
        P_controles.setLocation(new Point(P_tablero.getWidth() + 10, 5));
        add(P_controles);

        partida = Partida.getInstance();
    }

    public Partida getPartida() {
        return partida;
    }

}
