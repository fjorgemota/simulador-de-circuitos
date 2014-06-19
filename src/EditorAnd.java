class EditorAnd implements Editor {
	private Quadro quadro;
	EditorAnd(Quadro quadro){
		this.quadro = quadro;
	}
	public void clique(int x, int y){
        this.quadro.addFig(new FigAnd(new Ponto(x, y), new Ponto(x, y)));
        this.quadro.repaint();
	}
}
