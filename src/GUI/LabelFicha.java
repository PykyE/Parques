package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;

public class LabelFicha extends JLabel {

    private final int width = 25, heigth = 25;
    private String id;
    private Color color;

    public LabelFicha(int id) {
        this.id = String.valueOf(id);
        setSize(new Dimension(width, heigth));
        repaint();
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillOval(0, 0, width, heigth);
        if (color == Color.RED || color == Color.blue) {
            g2.setColor(Color.WHITE);
        } else {
            g2.setColor(Color.BLACK);
        }
        g2.drawString(id, (width / 2) - 5, heigth / 2);
    }

    public Color getColor() {
        return color;
    }

}
