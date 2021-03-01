package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

public class LabelFicha extends JLabel {

    private final int width = 30, heigth = 30;

    private Color color;

    public LabelFicha() {
        setSize(new Dimension(width, heigth));
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("label");
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillOval(0, 0, width, heigth);
    }

    public Color getColor() {
        return color;
    }

}
