package editores;

import views.*;
import models.*;

public class EditorXor implements Editor {
    private Quadro quadro;
    public EditorXor(Quadro quadro){
        this.quadro = quadro;
    }
    public void clique(int x, int y){
        this.quadro.addFig(new FigXOR(new Ponto(x,y), new Ponto(x,y)));
        this.quadro.repaint();
    }
}