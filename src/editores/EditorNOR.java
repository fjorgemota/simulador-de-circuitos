package editores;

import models.Ponto;
import views.FigNOR;
import views.Quadro;


public class EditorNOR extends EditorPortaLogica {
    public EditorNOR(Quadro quadro) {
        super(quadro);
    }

    public boolean clique(int x, int y) {
        FigNOR nand = new FigNOR(new Ponto(x, y));
        if (this.continuaInsercao(nand)) {
            this.quadro.addFig(nand);
            this.quadro.repaint();
            return true;
        }
        return false;
    }
}