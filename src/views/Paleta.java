package views;

import editores.*;

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

    public Paleta(Quadro quadro) {
        this.quadro = quadro;
        this.editor = null;
    }

    public Editor editor() {
        return editor;
    }

    public void actionPerformed(ActionEvent e) {
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
    }
}
