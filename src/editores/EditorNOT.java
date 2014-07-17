package editores;

import views.*;
import models.*;

public class EditorNOT extends EditorPortaLogica {
	public EditorNOT(Quadro quadro){
		super(quadro);
	}
	public void clique(int x, int y){
        FigNOT not = new FigNOT(new Ponto(x, y));
        if(this.continuaInsercao(not)) {
            this.quadro.addFig(not);
            this.quadro.repaint();
        }
	}
}