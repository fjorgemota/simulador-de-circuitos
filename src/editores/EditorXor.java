package editores;

import views.*;
import models.*;

public class EditorXor extends EditorPortaLogica{
    public EditorXor(Quadro quadro){
        super(quadro);
    }
    public void clique(int x, int y){
        FigXOR xor = new FigXOR(new Ponto(x,y));
        if(this.continuaInsercao(xor)) {
            this.quadro.addFig(xor);
            this.quadro.repaint();
        }
    }
}