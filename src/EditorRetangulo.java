class EditorRetangulo implements Editor{
    private Quadro quadro;
    private Ponto primeiroPonto;
    EditorRetangulo(Quadro quadro){
        this.quadro = quadro;
    }

     public void clique(int x, int y){
        if(primeiroPonto == null){
            primeiroPonto = new Ponto(x,y);
        }
        else{
            this.quadro.addFig(new FigRetangulo(primeiroPonto, new Ponto(x,y)));
            this.quadro.repaint();
            primeiroPonto = null;
        }
     }
}
