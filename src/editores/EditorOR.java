package editores;

import views.*;
import models.*;


public class EditorOR extends EditorPortaLogica{
	public EditorOR(Quadro quadro){
		super(quadro);
	}
	public void clique(int x, int y){
        FigOR or = new FigOR(new Ponto(x, y), new Ponto(x, y));
        if(this.continuaInsercao(or)) {
            this.quadro.addFig(or);
            this.quadro.repaint();
        }
	}
}