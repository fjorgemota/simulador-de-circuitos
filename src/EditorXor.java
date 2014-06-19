public class EditorXor implements Editor {
    private Quadro quadro;
    EditorXor(Quadro quadro){
        this.quadro = quadro;
    }
    public void clique(int x, int y){
        this.quadro.addFig(new FigXor(new Ponto(x,y), new Ponto (x,y)));
        this.quadro.repaint();
    }
}