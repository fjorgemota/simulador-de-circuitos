package editores;

import models.Ponto;
import views.FigAND;
import views.FigBotao;
import views.Quadro;

public class EditorBotao extends EditorPortaLogica {
    public EditorBotao(Quadro quadro) {
        super(quadro);
    }

    public void clique(int x, int y) {
        FigBotao botao = new FigBotao(new Ponto(x, y));
        if (this.continuaInsercao(botao)) {
            this.quadro.addFig(botao);
            this.quadro.repaint();
        }
    }
}
