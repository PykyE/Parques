package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTablero extends JPanel {

    private JLabel labelTablero;

    public PanelTablero() {
        initTemplate();
    }

    private void initComponents() {
        labelTablero = new JLabel();
        labelTablero.setSize(new Dimension(getWidth() - 10, getHeight() - 10));
        labelTablero.setLocation(new Point(5, 5));
        labelTablero.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setImagen(labelTablero, "Tablero.png");
        add(labelTablero);
    }

    public void initTemplate() {
        setLayout(null);
        setSize(new Dimension(600, 600));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(new Color(255, 140, 0));
        initComponents();
    }

    private void setImagen(JLabel label, String nombreImg) {
        String rutaBase = "src/Resources/" + nombreImg;
        ImageIcon instr = new ImageIcon(rutaBase);
        Image imginstr = instr.getImage();
        Image nuevaimagen = imginstr.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imagen = new ImageIcon(nuevaimagen);
        label.setIcon(imagen);
    }

}
