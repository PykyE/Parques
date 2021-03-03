package GUI;

import Logic.Singleton.Partida;
import Utilities.Coordenadas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTablero extends JPanel implements MouseListener {

    private JLabel labelTablero;
    int x,y;

    public PanelTablero() {
        Coordenadas.llenarCoordenadas();
        addMouseListener(this);
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

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        labelTablero.removeAll();
        Partida.getInstance().getJugadores().forEach((jugador) -> {
            jugador.getFichas().forEach((ficha) -> {
                labelTablero.add(ficha.getLblFicha());
            });
        });
        labelTablero.repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String myString = e.getX() + "," + e.getY();
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
