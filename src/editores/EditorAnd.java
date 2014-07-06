package editores;

import views.*;
import models.*;

public class EditorAnd implements Editor {
	private Quadro quadro;
	public EditorAnd(Quadro quadro){
		this.quadro = quadro;
	}
	public void clique(int x, int y){
        this.quadro.addFig(new FigAND(new Ponto(x, y), new Ponto(x, y)));
        this.quadro.repaint();
	}
}