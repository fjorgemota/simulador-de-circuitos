package editores;

import views.*;
import models.*;

import javax.swing.*;

public class EditorNand extends EditorPortaLogica {
    public EditorNand(Quadro quadro){
        super(quadro);
    }
    public void clique(int x, int y){
        FigNAND nand = new FigNAND(new Ponto(x,y), new Ponto(x,y));
        if(this.continuaInsercao(nand)){
            this.quadro.addFig(nand);
            this.quadro.repaint();
        }
    }
}