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

    private JLabel LblTurno, LblDado1, LblDado2, LblFichasDisp, LblAccion;
    private ArrayList<JCheckBox> JCboxes = new ArrayList<>();
    private JButton BtnTirar, BtnMovSac;
    private JPanel PnlFichas;

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

        LblAccion = new JLabel();
        LblAccion.setSize(new Dimension(285, 30));
        LblAccion.setLocation(new Point(5, LblDado1.getY() + LblDado1.getHeight() + 20));
        LblAccion.setFont(new Font("Montserrat Alternates", Font.BOLD, 20));
        LblAccion.setHorizontalAlignment(JLabel.CENTER);
        LblAccion.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(LblAccion);

        LblFichasDisp = new JLabel("Fichas disponibles");
        LblFichasDisp.setSize(new Dimension(285, 30));
        LblFichasDisp.setLocation(new Point(5, LblAccion.getY() + LblAccion.getHeight() + 20));
        LblFichasDisp.setFont(new Font("Montserrat Alternates", Font.BOLD, 20));
        LblFichasDisp.setHorizontalAlignment(JLabel.CENTER);
        LblFichasDisp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(LblFichasDisp);

        PnlFichas = new JPanel(new GridLayout(1, 4));
        PnlFichas.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        PnlFichas.setSize(new Dimension(getWidth() - 10, 65));
        PnlFichas.setLocation(new Point(5, LblFichasDisp.getY() + LblFichasDisp.getHeight() + 20));
        add(PnlFichas);

        BtnMovSac = new JButton();
        BtnMovSac.setFont(new Font("Montserrat Alternates", Font.PLAIN, 20));
        BtnMovSac.setFocusable(false);
        BtnMovSac.setSize(200, 30);
        BtnMovSac.setEnabled(false);
        BtnMovSac.setLocation(new Point((getWidth() - BtnMovSac.getWidth()) / 2, PnlFichas.getY() + PnlFichas.getHeight() + 20));
        BtnMovSac.setBackground(new Color(144, 238, 144));
        add(BtnMovSac);

    }

    private void pasarTurno() {
        Partida.getInstance().setSiguienteJugador();
        BtnMovSac.setText("");
        BtnMovSac.setEnabled(false);
        BtnTirar.setEnabled(true);
        PnlFichas.removeAll();
        LblTurno.setText(getText(Partida.getInstance().getTurnoActual().getNameColor()));
        JCboxes.clear();
        frameRef.getP_tablero().repaint();
        repaint();
    }

    private void initListeners() {
        BtnTirar.addActionListener((e) -> {
            results = frameRef.getPartida().getTurnoActual().tirarDados();
            LblDado1.setText("" + results[0]);
            LblDado2.setText("" + results[1]);
            opciones(results);
        });

        BtnMovSac.addActionListener((e) -> {
            if (BtnMovSac.getText().equals("Mover fichas")) {

            } else if (BtnMovSac.getText().equals("Sacar fichas")) {
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

    public void opciones(int[] values) {
        PnlFichas.removeAll();

        Jugador actualPlayer = Partida.getInstance().getTurnoActual();
        ArrayList carcel = actualPlayer.getCarcel();
        ArrayList won = actualPlayer.getWon();
        ArrayList fichas = actualPlayer.getFichas();

        if (carcel.isEmpty()) {
            showFichasOptions(carcel, fichas, won, false);
            BtnTirar.setEnabled(false);
            BtnMovSac.setText("Mover fichas");
            BtnMovSac.setEnabled(true);
        } else {
            if (values[0] == values[1]) {
                if (values[0] == 1 || values[0] == 6) {
                    showFichasOptions(carcel, fichas, won, true);
                    BtnTirar.setEnabled(false);
                    BtnMovSac.setText("Sacar fichas");
                    BtnMovSac.setEnabled(true);
                } else {
                    for (int i = 0; i < carcel.size(); i++) {
                        generateJCB(i, true);
                    }
                    BtnTirar.setEnabled(false);
                    BtnMovSac.setText("Sacar fichas");
                    BtnMovSac.setEnabled(true);
                }
            }
        }
    }

    public void showFichasOptions(ArrayList carcel, ArrayList fichas, ArrayList won, boolean allPieces) {
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
        PnlFichas.add(newJCB);
        JCboxes.add(newJCB);
    }

    public void ValidarCondicionesMover() throws NumFichasSeleccIncorrecto {

    }

    public ArrayList<Ficha> ValidarCondicionesSacar(boolean allPieces) throws NumFichasSeleccIncorrecto {
        int cont = 0;
        ArrayList<Ficha> fichas = new ArrayList<>();
        for (int i = 0; i < JCboxes.size(); i++) {
            if (JCboxes.get(i).isSelected()) {
                fichas.add(Partida.getInstance().getTurnoActual().getFichas().get((Integer.parseInt(JCboxes.get(i).getText()) - 1)));
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
    
    public String getText(String nameColor){
        System.out.println(nameColor);
        String estructura = "<html><body>";
        switch(nameColor){
            case "Azul" -> {
                estructura += "<p>Turno jugador: <span style='color:blue;'>"+nameColor+"</span></p>";
                break;
            }
            case "Verde" -> {
                estructura += "<p>Turno jugador: <span style='color:green;'>"+nameColor+"</span></p>";
                break;
            }
            case "Rojo" -> {
                estructura += "<p>Turno jugador: <span style='color:red;'>"+nameColor+"</span></p>";
                break;
            }
            case "Amarillo" -> {
                estructura += "<p>Turno jugador: <span style='color:yellow;'>"+nameColor+"</span></p>";
                break;
            }
        }
        estructura +="</body></html>";
        return estructura;
    }

}
