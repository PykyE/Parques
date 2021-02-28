package GUI;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Frame extends JFrame {

    private final int ancho = 600;
    private final int alto = 600;

    public Frame() {
        //initTemplate();
    }

    public void initTemplate() {
        setLayout(null);
        setTitle("Parchis");
        setSize(new Dimension(ancho, alto));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        initListeners();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void initComponents() {

    }

    public void initListeners() {

    }

}
