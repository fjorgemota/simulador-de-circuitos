import views.Quadro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Main implements MouseListener, ActionListener {
    static Quadro quadro;
    static Paleta paleta;

    public static void main(String[] argv) {
        JFrame f = new JFrame();
        quadro = new Quadro();
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

        item = new JMenuItem("Retângulo");
        item.setActionCommand(Paleta.RETANGULO);
        item.addActionListener(paleta);
        guia.add(item);

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

        JMenu modo = new JMenu("Modo");
        barra.add(modo);

        item = new JMenuItem("Conectar");
        item.setEnabled(false);
        modo.add(item);

        item = new JMenuItem("Editar");
        item.setEnabled(true);
        modo.add(item);

        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 300);
        f.setTitle("Simulador de Circuitos");
        desenhar();
    }

    public void actionPerformed(ActionEvent e){
        System.exit(0); //sai da aplicação com o código de status zero
    }

    static void desenhar() {
        Main.quadro.addMouseListener(new Main());
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        Main.paleta.editor().clique(x, y);
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }
}