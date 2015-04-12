package editores;

import models.Ponto;
import views.FigXOR;
import views.Quadro;

public class EditorXor extends EditorPortaLogica {
    public EditorXor(Quadro quadro) {
        super(quadro);
    }

    public boolean clique(int x, int y) {
        FigXOR xor = new FigXOR(new Ponto(x, y));
        if (this.continuaInsercao(xor)) {
            this.quadro.addFig(xor);
            this.quadro.repaint();
            return true;
        }
        return false;
    }
}