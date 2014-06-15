class EditorAnd implements Editor {
	private Quadro quadro;
	EditorAnd(Quadro quadro){
		this.quadro = quadro;
	}
	public void clique(int x, int y){
        Main.quadro.addFig(new FigAnd(new Ponto(x, y), new Ponto(x, y)));
        Main.quadro.repaint();
	}
}
