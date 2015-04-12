package editores;

import models.Ponto;
import views.FigNOT;
import views.Quadro;

public class EditorNOT extends EditorPortaLogica {
    public EditorNOT(Quadro quadro) {
        super(quadro);
    }

    public boolean clique(int x, int y) {
        FigNOT not = new FigNOT(new Ponto(x, y));
        if (this.continuaInsercao(not)) {
            this.quadro.addFig(not);
            this.quadro.repaint();
            return true;
        }
        return false;
    }
}