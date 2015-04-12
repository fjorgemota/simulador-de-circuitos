package views;

import editores.*;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Permite a selecao de editores. E SO isso.
 */
public class Paleta implements ActionListener {
    public static String
            AND = "AND",
            OR = "OR",
            XOR = "XOR",
            NOR = "NOR",
            NOT = "NOT",
            NXOR = "NXOR",
            NAND = "NAND",
            LINHA = "LINHA",
            BOTAO = "BOTAO";
    private Editor editor;
    private Quadro quadro;
    private Modo modo;

    public Paleta(Quadro quadro, Modo modo) {
        this.quadro = quadro;
        this.modo = modo;
        this.editor = null;
    }

    public Editor editor() {
        return editor;
    }

    public void actionPerformed(ActionEvent e) {
        JButton botao = (JButton) e.getSource();
        if (botao.getBackground().equals(Color.CYAN)) {
            this.editor = null;
            modo.setaEditando();
            botao.setBackground(null);
            return;
        }
        if (modo.estaCriando()) {
            JOptionPane.showMessageDialog(null, "Apenas uma ferramenta pode ser selecionada por vez!");
            return;
        }
        modo.setaCriando();
        String comando = e.getActionCommand();
        if (comando.equals(AND)) {
            this.editor = new EditorAnd(this.quadro);
        } else if (comando.equals(OR)) {
            this.editor = new EditorOR(this.quadro);
        } else if (comando.equals(XOR)) {
            this.editor = new EditorXor(this.quadro);
        } else if (comando.equals(NOR)) {
            this.editor = new EditorNOR(this.quadro);
        } else if (comando.equals(NOT)) {
            this.editor = new EditorNOT(this.quadro);
        } else if (comando.equals(NXOR)) {
            this.editor = new EditorNXOR(this.quadro);
        } else if (comando.equals(NAND)) {
            this.editor = new EditorNand(this.quadro);
        } else if (comando.equals(LINHA)) {
            this.editor = new EditorLinha(this.quadro);
        } else if (comando.equals(BOTAO)) {
            this.editor = new EditorBotao(this.quadro);
        }
        botao.setBackground(Color.CYAN);
    }
}
