import editores.Editor;
import views.Modo;
import views.Paleta;
import views.Quadro;
import views.Reproduzivel;

import javax.swing.*;
import java.awt.event.*;

public class Main implements MouseListener, MouseMotionListener, ActionListener {
    static Quadro quadro;
    static Paleta paleta;
    static Modo modo;
    static Reproduzivel figuraSelecionada;

    public static void main(String[] argv) {
        JFrame f = new JFrame();
        quadro = new Quadro();
        modo = new Modo();
        paleta = new Paleta(quadro);
        f.setContentPane(quadro);
        JMenuBar barra = new JMenuBar();
        f.setJMenuBar(barra);

        JMenu guia;
        guia = new JMenu("Arquivo");
        barra.add(guia);

        JMenuItem item;
        item = new JMenuItem("Sair");
        item.addActionListener(new Main());
        guia.add(item);

        guia = new JMenu("Paleta");
        barra.add(guia);

        item = new JMenuItem("Porta AND");
        item.setActionCommand(Paleta.AND);
        item.addActionListener(paleta);
        guia.add(item);

        item = new JMenuItem("Porta OR");
        item.setActionCommand(Paleta.OR);
        item.addActionListener(paleta);
        guia.add(item);

        item = new JMenuItem("Porta XOR");
        item.setActionCommand(Paleta.XOR);
        item.addActionListener(paleta);
        guia.add(item);

        item = new JMenuItem("Porta NOT");
        item.setActionCommand(Paleta.NOT);
        item.addActionListener(paleta);
        guia.add(item);

        item = new JMenuItem("Porta NAND");
        item.setActionCommand(Paleta.NAND);
        item.addActionListener(paleta);
        guia.add(item);

        item = new JMenuItem("Porta NOR");
        item.setActionCommand(Paleta.NOR);
        item.addActionListener(paleta);
        guia.add(item);

        item = new JMenuItem("Porta NXOR");
        item.setActionCommand(Paleta.NXOR);
        item.addActionListener(paleta);
        guia.add(item);

        item = new JMenuItem("Conector");
        item.setActionCommand(Paleta.LINHA);
        item.addActionListener(paleta);
        guia.add(item);

        guia = new JMenu("Modo");
        barra.add(guia);

        item = new JMenuItem("Criar");
        item.setActionCommand(Modo.CRIAR);
        item.addActionListener(modo);
        guia.add(item);

        item = new JMenuItem("Editar");
        item.setActionCommand(Modo.EDITAR);
        item.addActionListener(modo);
        guia.add(item);

        item = new JMenuItem("Apagar");
        item.setActionCommand(Modo.APAGAR);
        item.addActionListener(modo);
        guia.add(item);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800, 600);
        f.setTitle("Simulador de Circuitos");
        desenhar();
    }

    public void actionPerformed(ActionEvent e){
        System.exit(0); //sai da aplicação com o código de status zero
    }

    static void desenhar() {
        Main main = new Main();
        Main.quadro.addMouseListener(main);
        Main.quadro.addMouseMotionListener(main);
    }

    public void mouseClicked(MouseEvent e) {
        if (modo.estaCriando()) {
            int x = e.getX();
            int y = e.getY();
            Editor editor = Main.paleta.editor();
            if(editor == null){
                JOptionPane.showMessageDialog(null, "Selecione um componente no menu 'Paleta'!");

            } else {
                editor.clique(x, y);
            }
        }
    }

    public void mousePressed(MouseEvent e) {
        if (modo.estaEditando()) {
            int x = e.getX();
            int y = e.getY();
            figuraSelecionada = Main.quadro.pegaObjetoEm(x, y);
            if(figuraSelecionada == null) {
                JOptionPane.showMessageDialog(null, "Selecione um componente e arraste!");
            }
            else {
                figuraSelecionada.selecionaPonto(x, y);
            }
        }
        else if(modo.estaApagando()){
            int x = e.getX();
            int y = e.getY();
            figuraSelecionada = Main.quadro.pegaObjetoEm(x, y);
            if(figuraSelecionada == null) {
                JOptionPane.showMessageDialog(null, "Selecione um componente para apagar");
            }
            else {
                quadro.removeFig(figuraSelecionada);
                quadro.repaint();
            }
        }
    }

    public void mouseReleased(MouseEvent e) {
        if (modo.estaEditando() && figuraSelecionada != null) {
            figuraSelecionada = null;
        }
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