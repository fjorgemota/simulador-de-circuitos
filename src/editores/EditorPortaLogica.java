package editores;

import models.PortaLogica;
import views.Quadro;

import javax.swing.*;

public abstract class EditorPortaLogica implements Editor {
    protected Quadro quadro;
    public EditorPortaLogica(Quadro quadro) {
        this.quadro = quadro;
    }
    protected boolean colideCom(PortaLogica porta) {
       return this.quadro.pegaObjetoEm(porta.x(), porta.y()) != null
                || this.quadro.pegaObjetoEm(porta.x() + porta.largura(), porta.y()) != null
                || this.quadro.pegaObjetoEm(porta.x(), porta.y() + porta.altura()) != null
                || this.quadro.pegaObjetoEm(porta.x() + porta.largura(), porta.y() + porta.altura()) != null;
    }
    protected boolean continuaInsercao(PortaLogica porta) {
        if(this.colideCom(porta)){
            JOptionPane.showMessageDialog(null, "Não sobreponha esta porta lógica sob outra porta lógica ou cabo!");
            return false;
        }
        else {
            return true;
        }
    }
}
