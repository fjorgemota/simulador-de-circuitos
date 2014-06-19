public class EditorNand implements Editor {
    private Quadro quadro;
    EditorNand(Quadro quadro){
        this.quadro = quadro;
    }
    public void clique(int x, int y){
        this.quadro.addFig(new FigNand(new Ponto(x,y), new Ponto(x,y)));
        this.quadro.repaint();
    }
}