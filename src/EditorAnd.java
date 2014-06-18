class EditorAnd implements Editor {
	private Quadro quadro;
	EditorAnd(Quadro quadro){
		this.quadro = quadro;
	}
	public void clique(int x, int y){
        Ponto ponto1, ponto2;
        ponto1 = new Ponto(x, y);
        ponto2 = new Ponto(x, y);
        FigAnd desenho = new FigAnd(ponto1, ponto2);
        // Para centralizar dois pontos a partir do que foi informado no desenho. Faz sentido?
        ponto1.deslocarX(-(desenho.largura()/2));
        ponto1.deslocarY(-(desenho.altura()/2));
        ponto2.deslocarX((desenho.largura()/2));
        ponto2.deslocarY((desenho.altura()/2));
        this.quadro.addFig(desenho);
        this.quadro.repaint();
	}
}
