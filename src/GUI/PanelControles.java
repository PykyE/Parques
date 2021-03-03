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

    private JLabel LblTurno, LblDado1, LblDado2, LblMov1, LblMov2;
    private ArrayList<JCheckBox> JCboxesSacar = new ArrayList<>();
    private ArrayList<JCheckBox> JCboxesMover1 = new ArrayList<>();
    private ArrayList<JCheckBox> JCboxesMover2 = new ArrayList<>();
    private ArrayList<JCheckBox> JCboxesDado1 = new ArrayList<>();
    private ArrayList<JCheckBox> JCboxesDado2 = new ArrayList<>();
    private JButton BtnTirar, BtnSacar, BtnMover;
    private JPanel PnlFichasSacar, PnlFichasMoverDado1, PnlFichasMoverDado2, PnlDados1, PnlDados2;

    private int[] results = new int[2];

    private Frame frameRef;

    public PanelControles(Frame frame) {
        frameRef = frame;
        initTemplate();
    }

    private void initComponents() {
        LblTurno = new JLabel(getText(Partida.getInstance().getTurnoActual().getNameColor()));
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

        LblMov1 = new JLabel("Movimiento #1");
        LblMov1.setSize(new Dimension(285, 30));
        LblMov1.setLocation(new Point(getWidth() - LblMov1.getWidth() - 5, (BtnMover.getY() + BtnMover.getHeight() + 20)));
        LblMov1.setFont(new Font("Montserrat Alternates", Font.BOLD, 15));
        LblMov1.setHorizontalAlignment(JLabel.CENTER);
        LblMov1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(LblMov1);

        PnlFichasMoverDado1 = new JPanel(new GridLayout(1, 4));
        PnlFichasMoverDado1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PnlFichasMoverDado1.setSize(new Dimension(getWidth() - 10, 35));
        PnlFichasMoverDado1.setLocation(new Point(5, LblMov1.getY() + LblMov1.getHeight() + 10));
        add(PnlFichasMoverDado1);

        PnlDados1 = new JPanel(new GridLayout(1, 4));
        PnlDados1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PnlDados1.setSize(new Dimension(getWidth() - 10, 35));
        PnlDados1.setLocation(new Point(5, PnlFichasMoverDado1.getY() + PnlFichasMoverDado1.getHeight() + 20));
        add(PnlDados1);

        LblMov2 = new JLabel("Movimiento #2");
        LblMov2.setSize(new Dimension(285, 30));
        LblMov2.setLocation(new Point(getWidth() - LblMov2.getWidth() - 5, (PnlDados1.getY() + PnlDados1.getHeight() + 20)));
        LblMov2.setFont(new Font("Montserrat Alternates", Font.BOLD, 15));
        LblMov2.setHorizontalAlignment(JLabel.CENTER);
        LblMov2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(LblMov2);

        PnlFichasMoverDado2 = new JPanel(new GridLayout(1, 4));
        PnlFichasMoverDado2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PnlFichasMoverDado2.setSize(new Dimension(getWidth() - 10, 35));
        PnlFichasMoverDado2.setLocation(new Point(5, LblMov2.getY() + LblMov2.getHeight() + 10));
        add(PnlFichasMoverDado2);

        PnlDados2 = new JPanel(new GridLayout(1, 4));
        PnlDados2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PnlDados2.setSize(new Dimension(getWidth() - 10, 35));
        PnlDados2.setLocation(new Point(5, PnlFichasMoverDado2.getY() + PnlFichasMoverDado2.getHeight() + 20));
        add(PnlDados2);

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
                } else if (Partida.getInstance().getTurnoActual().getCarcel().size() != 1) {
                    ArrayList<Ficha> values = ValidarCondicionesSacar(false);
                    Partida.getInstance().getTurnoActual().sacarFichas("Dos", values);
                } else {
                    ArrayList<Ficha> values = ValidarCondicionesSacar(false);
                    Partida.getInstance().getTurnoActual().sacarFichas("Uno", values);
                }
                pasarTurno();
            } catch (NumFichasSeleccIncorrecto ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        BtnMover.addActionListener((e) -> {
            try {
                ArrayList<ArrayList> res = ValidarCondicionesMover();

                ArrayList<Ficha> fichaSelecc1 = res.get(0);
                ArrayList<Ficha> fichaSelecc2 = res.get(1);

                int idFichaSelecc1 = fichaSelecc1.get(0).getiD();
                int idFichaSelecc2 = fichaSelecc2.get(0).getiD();

                String dadoSelecc1 = res.get(2).get(0).toString();
                String dadoSelecc2 = res.get(3).get(0).toString();

                if ((idFichaSelecc1 == idFichaSelecc2)) {
                    Partida.getInstance().getTurnoActual().mover(fichaSelecc1, (dadoSelecc1.equals("Dado 1")) ? results[0] : results[1], (dadoSelecc2.equals("Dado 1")) ? results[0] : results[1]);
                } else {
                    fichaSelecc1.add(fichaSelecc2.get(0));
                    Partida.getInstance().getTurnoActual().mover(fichaSelecc1, (dadoSelecc1.equals("Dado 1")) ? results[0] : results[1], (dadoSelecc2.equals("Dado 1")) ? results[0] : results[1]);
                }
                pasarTurno();
            } catch (NumFichasSeleccIncorrecto ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
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
            showFichasOptionsMover(carcel, fichas, won);
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
                        generateJCBSacar(index, true);
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
                    showFichasOptionsMover(carcel, fichas, won);
                    BtnTirar.setEnabled(false);
                    BtnSacar.setEnabled(false);
                    BtnMover.setEnabled(true);
                }
            }
        }
    }

    public void showFichasXSacar(ArrayList carcel, ArrayList fichas, ArrayList won, boolean allPieces) {
        for (int i = 0; i < carcel.size(); i++) {
            if (allPieces) {
                if (!won.contains(fichas.get(i))) {
                    int index = fichas.indexOf(carcel.get(i));
                    generateJCBSacar(index, false);
                }

            } else {
                if (!carcel.contains(fichas.get(i)) && !won.contains(fichas.get(i))) {
                    int index = fichas.indexOf(carcel.get(i));
                    generateJCBSacar(index, true);
                }
            }
        }
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
            if (cont != Partida.getInstance().getTurnoActual().getCarcel().size()) {
                throw new NumFichasSeleccIncorrecto("Error sacar todas las fichas de putazo");
            } else {
                return fichas;
            }
        } else {
            if (cont != 2) {
                if (Partida.getInstance().getTurnoActual().getCarcel().size() == 1) {
                    return fichas;
                } else {
                    throw new NumFichasSeleccIncorrecto("Numero de fichas seleccionadas incorrecto");
                }
            } else {
                return fichas;
            }
        }
    }

    public void generateJCBSacar(int i, boolean enabled) {
        JCheckBox newJCB = new JCheckBox(String.valueOf(i + 1));
        newJCB.setBackground(null);
        newJCB.setFocusable(false);
        newJCB.setEnabled(enabled);
        newJCB.setSelected(!enabled);
        PnlFichasSacar.add(newJCB);
        JCboxesSacar.add(newJCB);
    }

    public void showFichasOptionsMover(ArrayList carcel, ArrayList fichas, ArrayList won) {
        for (int i = 0; i < 4; i++) {
            if (!carcel.contains(fichas.get(i)) && !won.contains(fichas.get(i))) {
                generateJCBSMover(i);
            }
        }
        generateJCBSDados();
    }

    public ArrayList<ArrayList> ValidarCondicionesMover() throws NumFichasSeleccIncorrecto {
        int contadorPanel1 = 0, contadorPanel2 = 0, contadorDados1 = 0, contadorDados2 = 0;
        ArrayList<ArrayList> retorno = new ArrayList<>();
        ArrayList<Ficha> seleccPanel1 = new ArrayList<>();
        ArrayList<Ficha> seleccPanel2 = new ArrayList<>();
        ArrayList<String> seleccPanelDados1 = new ArrayList<>();
        ArrayList<String> seleccPanelDados2 = new ArrayList<>();
        for (int i = 0; i < JCboxesMover1.size(); i++) {
            if (JCboxesMover1.get(i).isSelected()) {
                contadorPanel1++;
                seleccPanel1.add(Partida.getInstance().getTurnoActual().getFichas().get((Integer.parseInt(JCboxesMover1.get(i).getText()) - 1)));
            }
        }
        for (int i = 0; i < JCboxesMover2.size(); i++) {
            if (JCboxesMover2.get(i).isSelected()) {
                contadorPanel2++;
                seleccPanel2.add(Partida.getInstance().getTurnoActual().getFichas().get((Integer.parseInt(JCboxesMover2.get(i).getText()) - 1)));
            }
        }
        for (int i = 0; i < JCboxesDado1.size(); i++) {
            if (JCboxesDado1.get(i).isSelected()) {
                contadorDados1++;
                seleccPanelDados1.add(JCboxesDado1.get(i).getText());
            }
        }
        for (int i = 0; i < JCboxesDado2.size(); i++) {
            if (JCboxesDado2.get(i).isSelected()) {
                contadorDados2++;
                seleccPanelDados2.add(JCboxesDado2.get(i).getText());
            }
        }

        if (contadorPanel1 != 1 || contadorPanel2 != 1 || contadorDados1 != 1 || contadorDados2 != 1) {
            throw new NumFichasSeleccIncorrecto("Numero de fichas/dados seleccionados incorrecto");
        } else if ((seleccPanel1.get(0).getiD() != seleccPanel2.get(0).getiD()) && (seleccPanelDados1.get(0).toString() == seleccPanelDados2.get(0).toString())) {
            throw new NumFichasSeleccIncorrecto("Mismo valor de dados seleccionados para distintas fichas");
        } else if (seleccPanel1.get(0).getiD() == seleccPanel2.get(0).getiD() && seleccPanelDados1.get(0).toString() == seleccPanelDados2.get(0).toString() && results[0] != results[1]) {
            throw new NumFichasSeleccIncorrecto("Mismo valor de dados seleccionados para distintos dados");
        } else {
            retorno.add(seleccPanel1);
            retorno.add(seleccPanel2);
            retorno.add(seleccPanelDados1);
            retorno.add(seleccPanelDados2);
        }

        return retorno;
    }

    public void generateJCBSMover(int i) {
        JCheckBox newJCB1 = new JCheckBox(String.valueOf(i + 1));
        newJCB1.setBackground(null);
        newJCB1.setFocusable(false);
        PnlFichasMoverDado1.add(newJCB1);
        JCboxesMover1.add(newJCB1);

        JCheckBox newJCB2 = new JCheckBox(String.valueOf(i + 1));
        newJCB2.setBackground(null);
        newJCB2.setFocusable(false);
        PnlFichasMoverDado2.add(newJCB2);
        JCboxesMover2.add(newJCB2);
    }

    public void generateJCBSDados() {
        JCheckBox dado11 = new JCheckBox("Dado 1");
        dado11.setBackground(null);
        dado11.setFocusable(false);
        dado11.setSize(new Dimension(30, 30));

        JCheckBox dado12 = new JCheckBox("Dado 2");
        dado12.setBackground(null);
        dado12.setFocusable(false);
        dado12.setSize(new Dimension(30, 30));

        PnlDados1.add(dado11);
        PnlDados1.add(dado12);

        JCboxesDado1.add(dado11);
        JCboxesDado1.add(dado12);

        JCheckBox dado21 = new JCheckBox("Dado 1");
        dado21.setBackground(null);
        dado21.setFocusable(false);
        dado21.setSize(new Dimension(30, 30));

        JCheckBox dado22 = new JCheckBox("Dado 2");
        dado22.setBackground(null);
        dado22.setFocusable(false);
        dado22.setSize(new Dimension(30, 30));

        PnlDados2.add(dado21);
        PnlDados2.add(dado22);

        JCboxesDado2.add(dado21);
        JCboxesDado2.add(dado22);
    }

    private void pasarTurno() {
        Partida.getInstance().setSiguienteJugador();
        BtnSacar.setEnabled(false);
        BtnMover.setEnabled(false);
        BtnTirar.setEnabled(true);
        LblDado1.setText(null);
        LblDado2.setText(null);
        PnlFichasSacar.removeAll();
        PnlDados1.removeAll();
        PnlDados2.removeAll();
        PnlFichasMoverDado1.removeAll();
        PnlFichasMoverDado2.removeAll();
        JCboxesMover1.clear();
        JCboxesMover2.clear();
        JCboxesDado1.clear();
        JCboxesDado2.clear();
        JCboxesSacar.clear();
        LblTurno.setText(getText(Partida.getInstance().getTurnoActual().getNameColor()));
        frameRef.getP_tablero().repaint();
        repaint();
    }

    public String getText(String nameColor) {
        String estructura = "<html><body>";
        switch (nameColor) {
            case "Azul" -> {
                estructura += "<p>Turno jugador: <span style='color:blue;'>" + nameColor + "</span></p>";
                break;
            }
            case "Verde" -> {
                estructura += "<p>Turno jugador: <span style='color:green;'>" + nameColor + "</span></p>";
                break;
            }
            case "Rojo" -> {
                estructura += "<p>Turno jugador: <span style='color:red;'>" + nameColor + "</span></p>";
                break;
            }
            case "Amarillo" -> {
                estructura += "<p>Turno jugador: <span style='color:yellow;'>" + nameColor + "</span></p>";
                break;
            }
        }
        estructura += "</body></html>";
        return estructura;
    }

}
