class EditorNOT implements Editor {
	private Quadro quadro;
	EditorNOT(Quadro quadro){
		this.quadro = quadro;
	}
	public void clique(int x, int y){
        this.quadro.addFig(new FigNOT(new Ponto(x, y), new Ponto(x, y)));
        this.quadro.repaint();
	}
}