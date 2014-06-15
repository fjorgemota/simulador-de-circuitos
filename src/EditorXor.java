public class EditorXor implements Editor {
    private Quadro quadro;
    private Ponto primeiroPonto;
    EditorXor(Quadro quadro){
        this.quadro = quadro;
    }
    public void clique(int x, int y){
        if(primeiroPonto == null){
            primeiroPonto = new Ponto(x,y);
        }
        else{
            Ponto segundo = new Ponto(x,y);
            this.quadro.addFig(new FigRetangulo(primeiroPonto, segundo));
            //Metodo generico para posterior analise;
            this.quadro.repaint();
        }
    }
}