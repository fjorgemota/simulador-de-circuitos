import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paleta implements ActionListener {
    static String
            RETANGULO = "Retângulo",
            AND = "AND",
            OR = "OR",
            XOR = "XOR",
            NOR = "NOR",
            NOT = "NOT",
            NXOR = "NXOR",
            NAND = "NAND";
    private Editor editor;
    private Quadro quadro;
    private int raio = 20;
    Editor editor() {
        return editor;
    }
    Paleta(Quadro quadro){
        this.quadro = quadro;
        this.editor = new EditorRetangulo(quadro);
    }

    public void actionPerformed(ActionEvent e){
        String comando = e.getActionCommand();
        if(comando.equals(RETANGULO)){
            this.editor = new EditorRetangulo(this.quadro);
        } else if (comando.equals(AND)) {
            this.editor = new EditorAnd(this.quadro);
        }else if(comando.equals(OR)){
            this.editor = new EditorOR(this.quadro);
        }else if (comando.equals(XOR)){
            this.editor = new EditorXor(this.quadro);
        }else if(comando.equals(NOR)){
            this.editor = new EditorNOR(this.quadro);
        }else if(comando.equals(NOT)){
            this.editor = new EditorNOT(this.quadro);
        }else if(comando.equals(NXOR)){
            this.editor = new EditorNXOR(this.quadro);
        } else if(comando.equals(NAND)){
            this.editor = new EditorNand(this.quadro);
        }
    }
}
