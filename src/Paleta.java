import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paleta implements ActionListener {
    static String
            RETANGULO = "Retângulo",
            AND = "AND";
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
        }
    }
}
