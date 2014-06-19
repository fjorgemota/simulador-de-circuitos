class EditorOR implements Editor {
	private Quadro quadro;
	EditorOR(Quadro quadro){
		this.quadro = quadro;
	}
	public void clique(int x, int y){
        this.quadro.addFig(new FigOR(new Ponto(x, y), new Ponto(x, y)));
        this.quadro.repaint();
	}
}