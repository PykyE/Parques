package GUI;

import Logic.Singleton.Partida;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelControles extends JPanel {

    private JLabel LblTurno, LblDado1, LblDado2;
    private ArrayList<JCheckBox> JCboxes;
    private JButton BtnTirar;

    private Frame frameRef;

    public PanelControles(Frame frame) {
        frameRef = frame;
        initTemplate();
    }

    private void initComponents() {
        LblTurno = new JLabel("Turno actual: " + Partida.getInstance().getTurnoActual().getNombre());
        LblTurno.setSize(new Dimension(285, 30));
        LblTurno.setLocation(new Point(5, 5));
        LblTurno.setFont(new Font("Montserrat Alternates", Font.BOLD, 20));
        LblTurno.setHorizontalAlignment(JLabel.CENTER);
        LblTurno.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(LblTurno);

        BtnTirar = new JButton("Tirar dados");
        BtnTirar.setFont(new Font("Montserrat Alternates", Font.PLAIN, 20));
        BtnTirar.setFocusable(false);
        BtnTirar.setSize(200, 30);
        BtnTirar.setLocation(new Point((getWidth() - BtnTirar.getWidth()) / 2, 40));
        BtnTirar.setBackground(new Color(144, 238, 144));
        add(BtnTirar);

        LblDado1 = new JLabel();
        LblDado1.setSize(new Dimension(125, 30));
        LblDado1.setLocation(new Point(5, (BtnTirar.getY() + BtnTirar.getHeight() + 5)));
        LblDado1.setFont(new Font("Montserrat Alternates", Font.BOLD, 15));
        LblDado1.setHorizontalAlignment(JLabel.CENTER);
        LblDado1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(LblDado1);

        LblDado2 = new JLabel();
        LblDado2.setSize(new Dimension(125, 30));
        LblDado2.setLocation(new Point(getWidth() - LblDado2.getWidth() - 5, (BtnTirar.getY() + BtnTirar.getHeight() + 5)));
        LblDado2.setFont(new Font("Montserrat Alternates", Font.BOLD, 15));
        LblDado2.setHorizontalAlignment(JLabel.CENTER);
        LblDado2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(LblDado2);

        JCboxes = new ArrayList<>();

    }

    private void initListeners() {
        BtnTirar.addActionListener((e) -> {
            int[] results = frameRef.getPartida().getTurnoActual().tirarDados();
            LblDado1.setText("Valor dado 1: " + results[0]);
            LblDado2.setText("Valor dado 2: " + results[1]);
        });
    }

    public void initTemplate() {
        setLayout(null);
        setSize(new Dimension(295, 600));
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        setBackground(new Color(255, 221, 203));
        initComponents();
        initListeners();
    }

}
