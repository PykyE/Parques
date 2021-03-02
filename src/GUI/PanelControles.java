package GUI;

import Logic.Models.Jugador;
import Logic.Singleton.Partida;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelControles extends JPanel {

    private JLabel LblTurno, LblDado1, LblDado2, LblFichasDisp;
    private ArrayList<JCheckBox> JCboxes;
    private JButton BtnTirar;
    private JPanel PnlFichas;

    private Frame frameRef;

    public PanelControles(Frame frame) {
        frameRef = frame;
        initTemplate();
    }

    private void initComponents() {
        LblTurno = new JLabel("Turno: Jugador " + Partida.getInstance().getTurnoActual().getNameColor());
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
        BtnTirar.setLocation(new Point((getWidth() - BtnTirar.getWidth()) / 2, LblTurno.getY() + LblTurno.getHeight() + 20));
        BtnTirar.setBackground(new Color(144, 238, 144));
        add(BtnTirar);

        LblDado1 = new JLabel();
        LblDado1.setSize(new Dimension(125, 30));
        LblDado1.setLocation(new Point(5, (BtnTirar.getY() + BtnTirar.getHeight() + 20)));
        LblDado1.setFont(new Font("Montserrat Alternates", Font.BOLD, 15));
        LblDado1.setHorizontalAlignment(JLabel.CENTER);
        LblDado1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(LblDado1);

        LblDado2 = new JLabel();
        LblDado2.setSize(new Dimension(125, 30));
        LblDado2.setLocation(new Point(getWidth() - LblDado2.getWidth() - 5, (BtnTirar.getY() + BtnTirar.getHeight() + 20)));
        LblDado2.setFont(new Font("Montserrat Alternates", Font.BOLD, 15));
        LblDado2.setHorizontalAlignment(JLabel.CENTER);
        LblDado2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(LblDado2);

        LblFichasDisp = new JLabel("Fichas disponibles");
        LblFichasDisp.setSize(new Dimension(285, 30));
        LblFichasDisp.setLocation(new Point(5, LblDado1.getY() + LblDado1.getHeight() + 20));
        LblFichasDisp.setFont(new Font("Montserrat Alternates", Font.BOLD, 20));
        LblFichasDisp.setHorizontalAlignment(JLabel.CENTER);
        LblFichasDisp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(LblFichasDisp);

        JCboxes = new ArrayList<>();
        PnlFichas = new JPanel(new GridLayout(1, 4));
        PnlFichas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PnlFichas.setSize(new Dimension(getWidth() - 10, 65));
        PnlFichas.setLocation(new Point(5, LblFichasDisp.getY() + LblFichasDisp.getHeight() + 20));
        add(PnlFichas);

    }

    private void initListeners() {
        BtnTirar.addActionListener((e) -> {
            int[] results = frameRef.getPartida().getTurnoActual().tirarDados();
            LblDado1.setText("Valor dado 1: " + results[0]);
            LblDado2.setText("Valor dado 2: " + results[1]);
            opciones(results);
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

    public void opciones(int[] values) {

        if (values[0] == values[1]) {
            if ((values[0] == 6 && values[1] == 6) || ((values[0] == 1 && values[1] == 1))) {
                JOptionPane.showMessageDialog(null, "Saca las 4 fichas", "¡Par!", JOptionPane.INFORMATION_MESSAGE);
            } else {

            }
        } else {
            for (int i = 0; i < 4; i++) {
                
                Jugador actualPlayer = Partida.getInstance().getTurnoActual();
                
                JCheckBox newJCB = new JCheckBox(String.valueOf(i + 1));
                newJCB.setBackground(null);
                newJCB.setFocusable(false);
                newJCB.setSize(new Dimension(30, 30));
                newJCB.setLocation(new Point(5 + i * 85, LblDado1.getY() + LblDado1.getHeight() + 20));
                PnlFichas.add(newJCB);
            }
        }
    }

}
