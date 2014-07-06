package editores;

import views.*;
import models.*;

public class EditorNXOR extends EditorPortaLogica {
	public EditorNXOR(Quadro quadro){
		super(quadro);
	}
	public void clique(int x, int y){
        FigNXOR nxor = new FigNXOR(new Ponto(x, y), new Ponto(x, y));
        if(this.continuaInsercao(nxor)) {
            this.quadro.addFig(nxor);
            this.quadro.repaint();
        }
	}
}