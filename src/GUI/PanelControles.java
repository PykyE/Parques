package GUI;

import Exceptions.NumFichasSeleccIncorrecto;
import Logic.Models.Ficha;
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

    private JLabel LblTurno, LblDado1, LblDado2;
    private ArrayList<JCheckBox> JCboxesSacar = new ArrayList<>();
    private JButton BtnTirar, BtnSacar, BtnMover;
    private JPanel PnlFichasSacar, PnlFichasMoverDado1, PnlFichasMoverDado2, PnlDados1, PnlDados2;

    private int[] results = new int[2];

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

        BtnSacar = new JButton("Sacar fichas");
        BtnSacar.setFont(new Font("Montserrat Alternates", Font.PLAIN, 20));
        BtnSacar.setFocusable(false);
        BtnSacar.setSize(200, 30);
        BtnSacar.setEnabled(false);
        BtnSacar.setLocation(new Point((getWidth() - BtnSacar.getWidth()) / 2, LblDado2.getY() + LblDado2.getHeight() + 20));
        BtnSacar.setBackground(new Color(144, 238, 144));
        add(BtnSacar);

        PnlFichasSacar = new JPanel(new GridLayout(1, 4));
        PnlFichasSacar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PnlFichasSacar.setSize(new Dimension(getWidth() - 10, 35));
        PnlFichasSacar.setLocation(new Point(5, BtnSacar.getY() + BtnSacar.getHeight() + 20));
        add(PnlFichasSacar);

        BtnMover = new JButton("Mover fichas");
        BtnMover.setFont(new Font("Montserrat Alternates", Font.PLAIN, 20));
        BtnMover.setFocusable(false);
        BtnMover.setSize(200, 30);
        BtnMover.setEnabled(false);
        BtnMover.setLocation(new Point((getWidth() - BtnMover.getWidth()) / 2, PnlFichasSacar.getY() + PnlFichasSacar.getHeight() + 20));
        BtnMover.setBackground(new Color(144, 238, 144));
        add(BtnMover);

        PnlFichasMoverDado1 = new JPanel(new GridLayout(1, 4));
        PnlFichasMoverDado1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PnlFichasMoverDado1.setSize(new Dimension(getWidth() - 10, 35));
        PnlFichasMoverDado1.setLocation(new Point(5, BtnMover.getY() + BtnMover.getHeight() + 20));
        add(PnlFichasMoverDado1);

        PnlDados1 = new JPanel(new GridLayout(1, 4));
        PnlDados1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PnlDados1.setSize(new Dimension(getWidth() - 10, 35));
        PnlDados1.setLocation(new Point(5, PnlFichasMoverDado1.getY() + PnlFichasMoverDado1.getHeight() + 20));
        add(PnlDados1);

        PnlFichasMoverDado2 = new JPanel(new GridLayout(1, 4));
        PnlFichasMoverDado2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PnlFichasMoverDado2.setSize(new Dimension(getWidth() - 10, 35));
        PnlFichasMoverDado2.setLocation(new Point(5, PnlDados1.getY() + PnlDados1.getHeight() + 20));
        add(PnlFichasMoverDado2);

        PnlDados2 = new JPanel(new GridLayout(1, 4));
        PnlDados2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PnlDados2.setSize(new Dimension(getWidth() - 10, 35));
        PnlDados2.setLocation(new Point(5, PnlFichasMoverDado2.getY() + PnlFichasMoverDado2.getHeight() + 20));
        add(PnlDados2);

    }

    private void pasarTurno() {
        Partida.getInstance().setSiguienteJugador();
        BtnSacar.setEnabled(false);
        BtnMover.setEnabled(false);
        BtnTirar.setEnabled(true);
        LblDado1.setText(null);
        LblDado2.setText(null);
        PnlFichasSacar.removeAll();
        LblTurno.setText("Turno: Jugador " + Partida.getInstance().getTurnoActual().getNameColor());
        JCboxesSacar.clear();

        frameRef.getP_tablero().repaint();
        repaint();
    }

    private void initListeners() {
        BtnTirar.addActionListener((e) -> {
            results = frameRef.getPartida().getTurnoActual().tirarDados();
            LblDado1.setText("" + results[0]);
            LblDado2.setText("" + results[1]);
            opcionesTirarDados(results);
        });

        BtnSacar.addActionListener((e) -> {
            try {
                if ((results[0] == 1 && results[1] == 1) || (results[0] == 6 && results[1] == 6)) {
                    ArrayList<Ficha> values = ValidarCondicionesSacar(true);
                    Partida.getInstance().getTurnoActual().sacarFichas("Cuatro", values);
                } else {
                    ArrayList<Ficha> values = ValidarCondicionesSacar(false);
                    Partida.getInstance().getTurnoActual().sacarFichas("Dos", values);
                }
                pasarTurno();
            } catch (NumFichasSeleccIncorrecto ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        BtnMover.addActionListener((e) -> {

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

    public void opcionesTirarDados(int[] values) {
        PnlFichasSacar.removeAll();

        Jugador actualPlayer = Partida.getInstance().getTurnoActual();
        ArrayList carcel = actualPlayer.getCarcel();
        ArrayList won = actualPlayer.getWon();
        ArrayList fichas = actualPlayer.getFichas();

        if (carcel.isEmpty()) {
//            showFichasOptionsMover(carcel, fichas, won, false);
            BtnTirar.setEnabled(false);
            BtnSacar.setEnabled(false);
            BtnMover.setEnabled(true);
        } else {
            if (values[0] == values[1]) {
                if (values[0] == 1 || values[0] == 6) {
                    showFichasXSacar(carcel, fichas, won, true);
                    BtnTirar.setEnabled(false);
                    BtnSacar.setEnabled(true);
                    BtnMover.setEnabled(false);
                } else {
                    for (int i = 0; i < carcel.size(); i++) {
                        int index = fichas.indexOf(carcel.get(i));
                        generateJCB(index, true);
                    }
                    BtnTirar.setEnabled(false);
                    BtnSacar.setEnabled(true);
                    BtnMover.setEnabled(false);
                }
            } else {
                if (carcel.size() == fichas.size()) {
                    Partida.getInstance().getTurnoActual().setNroIntentos(Partida.getInstance().getTurnoActual().getNroIntentos() + 1);
                    if (Partida.getInstance().getTurnoActual().getNroIntentos() == 3) {
                        Partida.getInstance().getTurnoActual().setNroIntentos(0);
                        JOptionPane.showMessageDialog(null, "¡Siguiente turno!", "Status", JOptionPane.INFORMATION_MESSAGE);
                        pasarTurno();
                    }
                } else {
//                    showFichasOptionsMover(carcel, fichas, won, true);
                    BtnTirar.setEnabled(false);
                    BtnSacar.setEnabled(false);
                    BtnMover.setEnabled(true);
                }
            }
        }
    }

    public void showFichasXSacar(ArrayList carcel, ArrayList fichas, ArrayList won, boolean allPieces) {
        for (int i = 0; i < 4; i++) {
            if (allPieces) {
                generateJCB(i, false);
            } else {
                if (!carcel.contains(fichas.get(i)) && !won.contains(fichas.get(i))) {
                    generateJCB(i, true);
                }
            }

        }
    }

    public void generateJCB(int i, boolean enabled) {
        JCheckBox newJCB = new JCheckBox(String.valueOf(i + 1));
        newJCB.setBackground(null);
        newJCB.setFocusable(false);
        newJCB.setSize(new Dimension(30, 30));
        newJCB.setEnabled(enabled);
        newJCB.setSelected(!enabled);
        newJCB.setLocation(new Point(5 + i * 85, LblDado1.getY() + LblDado1.getHeight() + 20));
        PnlFichasSacar.add(newJCB);
        JCboxesSacar.add(newJCB);
    }

    public void ValidarCondicionesMover() throws NumFichasSeleccIncorrecto {

    }

    public ArrayList<Ficha> ValidarCondicionesSacar(boolean allPieces) throws NumFichasSeleccIncorrecto {
        int cont = 0;
        ArrayList<Ficha> fichas = new ArrayList<>();
        for (int i = 0; i < JCboxesSacar.size(); i++) {
            if (JCboxesSacar.get(i).isSelected()) {
                fichas.add(Partida.getInstance().getTurnoActual().getFichas().get((Integer.parseInt(JCboxesSacar.get(i).getText()) - 1)));
                cont++;
            }
        }
        if (allPieces) {
            if (cont != 4) {
                throw new NumFichasSeleccIncorrecto("Error sacar todas las fichas de putazo");
            } else {
                return fichas;
            }
        } else {
            if (cont != 2) {
                throw new NumFichasSeleccIncorrecto("Numero de fichas seleccionadas incorrecto");
            } else {
                return fichas;
            }
        }

    }

}
