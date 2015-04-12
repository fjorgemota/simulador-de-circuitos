package editores;

import models.Ponto;
import views.FigNAND;
import views.Quadro;

public class EditorNand extends EditorPortaLogica {
    public EditorNand(Quadro quadro) {
        super(quadro);
    }

    public boolean clique(int x, int y) {
        FigNAND nand = new FigNAND(new Ponto(x, y));
        if (this.continuaInsercao(nand)) {
            this.quadro.addFig(nand);
            this.quadro.repaint();
            return true;
        }
        return false;
    }
}