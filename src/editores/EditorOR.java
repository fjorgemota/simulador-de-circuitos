package editores;

import models.Ponto;
import views.FigOR;
import views.Quadro;


public class EditorOR extends EditorPortaLogica {
    public EditorOR(Quadro quadro) {
        super(quadro);
    }

    public boolean clique(int x, int y) {
        FigOR or = new FigOR(new Ponto(x, y));
        if (this.continuaInsercao(or)) {
            this.quadro.addFig(or);
            this.quadro.repaint();
            return true;
        }
        return false;
    }
}