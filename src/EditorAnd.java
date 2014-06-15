class EditorAnd implements Editor {
	private Quadro quadro;
	EditorAnd(Quadro quadro){
		this.quadro = quadro;
	}
	private int npontos;
	private int x0, y0;
	public void clique(int x, int y){
		if(npontos == 0){
			npontos = 1;
			x0 = x;
			y0 = y;
		}
		if(npontos == 1){
			Main.quadro.addFig(new FigRetangulo(new Ponto(x0, y0), new Ponto(x,y)));// novamente, como não sei como será o método de draw, deixarei de um modo "genérico" para posterior análise;
			Main.quadro.repaint();
		}		
	}
}
