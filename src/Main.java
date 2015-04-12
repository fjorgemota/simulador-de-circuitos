import editores.Editor;
import editores.EditorLinha;
import models.Botao;
import views.Modo;
import views.Paleta;
import views.Quadro;
import views.Reproduzivel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Main implements MouseListener, MouseMotionListener, ActionListener {
    static Quadro quadro;
    static Paleta paleta;
    static Modo modo;
    static JFileChooser fc;
    static JFrame f;
    static JToolBar toolbar;
    static Reproduzivel figuraSelecionada;
    static final String NEW = "NEW";
    static final String SAVE = "SAVE";
    static final String OPEN = "OPEN";
    static final String EXIT = "EXIT";


    public static void main(String[] argv) {
        f = new JFrame();
        fc = new JFileChooser();
        fc.setMultiSelectionEnabled(false);
        fc.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.getName().endsWith(".sim1");
            }

            @Override
            public String getDescription() {
                return "Simulador de Circuitor (.sim1)";
            }
        });
        fc.setAcceptAllFileFilterUsed(false);
        f.setLayout(new BorderLayout());
        quadro = new Quadro();
        modo = new Modo();
        paleta = new Paleta(quadro, modo);
        JMenuBar barra = new JMenuBar();
        f.setJMenuBar(barra);

        Main main = new Main();

        JMenu guia;
        guia = new JMenu("Arquivo");
        barra.add(guia);

        JMenuItem item;

        item = new JMenuItem("Novo");
        item.setActionCommand(NEW);
        item.addActionListener(main);
        guia.add(item);

        item = new JMenuItem("Abrir");
        item.setActionCommand(OPEN);
        item.addActionListener(main);
        guia.add(item);

        item = new JMenuItem("Salvar");
        item.setActionCommand(SAVE);
        item.addActionListener(main);
        guia.add(item);

        item = new JMenuItem("Sair");
        item.setActionCommand(EXIT);
        item.addActionListener(main);
        guia.add(item);

        toolbar = new JToolBar();
        toolbar.setOrientation(JToolBar.VERTICAL);
        JButton botao;
        f.add(toolbar, BorderLayout.WEST);
        f.add(new JScrollPane(
                quadro,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
        ), BorderLayout.CENTER, 1);


        botao = new JButton("Porta AND");
        botao.setActionCommand(Paleta.AND);
        botao.addActionListener(paleta);
        toolbar.add(botao);

        botao = new JButton("Porta OR");
        botao.setActionCommand(Paleta.OR);
        botao.addActionListener(paleta);
        toolbar.add(botao);

        botao = new JButton("Porta XOR");
        botao.setActionCommand(Paleta.XOR);
        botao.addActionListener(paleta);
        toolbar.add(botao);

        botao = new JButton("Porta NOT");
        botao.setActionCommand(Paleta.NOT);
        botao.addActionListener(paleta);
        toolbar.add(botao);

        botao = new JButton("Porta NAND");
        botao.setActionCommand(Paleta.NAND);
        botao.addActionListener(paleta);
        toolbar.add(botao);

        botao = new JButton("Porta NOR");
        botao.setActionCommand(Paleta.NOR);
        botao.addActionListener(paleta);
        toolbar.add(botao);

        botao = new JButton("Porta NXOR");
        botao.setActionCommand(Paleta.NXOR);
        botao.addActionListener(paleta);
        toolbar.add(botao);

        botao = new JButton("Conector");
        botao.setActionCommand(Paleta.LINHA);
        botao.addActionListener(paleta);
        toolbar.add(botao);

        botao = new JButton("Botão");
        botao.setActionCommand(Paleta.BOTAO);
        botao.addActionListener(paleta);
        toolbar.add(botao);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setTitle("Simulador de Circuitos");
        desenhar();
        for(Component c: toolbar.getComponents()) {
            botao = (JButton) c;
            botao.setBackground(null);
        }
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals(EXIT)) {
            System.exit(0); //sai da aplicação com o código de status zero
        }
        else if (command.equals(OPEN)) {
            int returnVal = fc.showOpenDialog(f);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                FileInputStream fi;
                ObjectInputStream is;
                ArrayList<Reproduzivel> q;
                try {
                    fi = new FileInputStream(file);
                    is = new ObjectInputStream(fi);
                    q =  (ArrayList<Reproduzivel>) is.readObject();
                    fi.close();
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Arquivo inválido!");
                    return;
                } catch(ClassNotFoundException e2) {
                    e2.printStackTrace();
                    return;
                }
                quadro.setFigs(q);
            }
        } else if(command.equals(SAVE)) {
            int returnVal = fc.showSaveDialog(f);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                if(!file.getAbsolutePath().endsWith(".sim1")) {
                    file = new File(file.getAbsolutePath()+".sim1");
                }
                FileOutputStream fo;
                ObjectOutputStream os;
                try {
                    fo = new FileOutputStream(file);
                    os = new ObjectOutputStream(fo);
                    os.writeObject(quadro.getFigs());
                    os.flush();
                    fo.close();
                } catch(FileNotFoundException e1) {
                    e1.printStackTrace();
                    return;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    return;
                }
            }

        } else if(command.equals(NEW)) {
            quadro.getFigs().clear();
            quadro.repaint();
        }
    }

    static void desenhar() {
        Main main = new Main();
        Main.quadro.addMouseListener(main);
        Main.quadro.addMouseMotionListener(main);
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (modo.estaCriando()) {
            Editor editor = Main.paleta.editor();
            if (editor != null) {
                if (editor.clique(x, y)) {
                    modo.setaEditando();
                    for(Component c: toolbar.getComponents()) {
                        JButton botao = (JButton) c;
                        botao.setBackground(null);
                    }
                }
            }
        } else if (modo.estaEditando()) {
            figuraSelecionada = Main.quadro.pegaObjetoEm(x, y);
            if (figuraSelecionada instanceof Botao) {
                figuraSelecionada.calcula();
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        if (modo.estaCriando()) {
            return;
        }
        int x = e.getX();
        int y = e.getY();
        figuraSelecionada = Main.quadro.pegaObjetoEm(x, y);
        if (figuraSelecionada != null) {
            if(e.getButton() == MouseEvent.BUTTON1) {
                figuraSelecionada.selecionaPonto(x, y);
            } else {
                quadro.removeFig(figuraSelecionada);
                quadro.repaint();
            }

        }
    }

    public void mouseReleased(MouseEvent e) {
        if (modo.estaCriando()) {
            return;
        }
        quadro.repaint();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
        if (modo.estaEditando() && figuraSelecionada != null) {
            int x = e.getX();
            int y = e.getY();
            figuraSelecionada.movePara(x, y);
            Main.quadro.repaint();
        }
    }

    public void mouseMoved(MouseEvent e) {

    }
}