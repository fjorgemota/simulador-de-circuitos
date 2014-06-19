class EditorNXOR implements Editor {
	private Quadro quadro;
	EditorNXOR(Quadro quadro){
		this.quadro = quadro;
	}
	public void clique(int x, int y){
        this.quadro.addFig(new FigNXOR(new Ponto(x, y), new Ponto(x, y)));
        this.quadro.repaint();
	}
}