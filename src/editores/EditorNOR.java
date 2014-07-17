package editores;

import views.*;
import models.*;

import javax.swing.*;


public class EditorNOR extends EditorPortaLogica {
	public EditorNOR(Quadro quadro){
		super(quadro);
	}
	public void clique(int x, int y){
        FigNOR nand = new FigNOR(new Ponto(x, y));
        if(this.continuaInsercao(nand)){
            this.quadro.addFig(nand);
            this.quadro.repaint();
        }
	}
}