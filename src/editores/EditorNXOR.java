package editores;

import models.Ponto;
import views.FigNXOR;
import views.Quadro;

public class EditorNXOR extends EditorPortaLogica {
    public EditorNXOR(Quadro quadro) {
        super(quadro);
    }

    public boolean clique(int x, int y) {
        FigNXOR nxor = new FigNXOR(new Ponto(x, y));
        if (this.continuaInsercao(nxor)) {
            this.quadro.addFig(nxor);
            this.quadro.repaint();
            return true;
        }
        return false;
    }
}