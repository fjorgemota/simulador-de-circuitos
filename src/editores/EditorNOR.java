package editores;

import views.*;
import models.*;


public class EditorNOR implements Editor {
	private Quadro quadro;
	public EditorNOR(Quadro quadro){
		this.quadro = quadro;
	}
	public void clique(int x, int y){
        this.quadro.addFig(new FigNOR(new Ponto(x, y), new Ponto(x, y)));
        this.quadro.repaint();
	}
}