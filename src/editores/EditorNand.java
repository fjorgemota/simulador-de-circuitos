package editores;

import views.*;
import models.*;

public class EditorNand implements Editor {
    private Quadro quadro;
    public EditorNand(Quadro quadro){
        this.quadro = quadro;
    }
    public void clique(int x, int y){
        this.quadro.addFig(new FigNAND(new Ponto(x,y), new Ponto(x,y)));
        this.quadro.repaint();
    }
}