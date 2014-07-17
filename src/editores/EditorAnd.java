package editores;

import views.*;
import models.*;

import javax.swing.*;

public class EditorAnd extends EditorPortaLogica {
	public EditorAnd(Quadro quadro){
        super(quadro);
	}
	public void clique(int x, int y){
        FigAND and = new FigAND(new Ponto(x, y));
        if(this.continuaInsercao(and)){
            this.quadro.addFig(and);
            this.quadro.repaint();
        }
	}
}
