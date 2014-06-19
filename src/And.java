class And extends PortaLogica{
	And(Ponto a, Ponto b){
		super(a, b);
	}

	public Entrada[] pegaEntradas() {
		Entrada[] entradasAnd = new Entrada[2];
		entradasAnd[0] = new Entrada(30, 25);
		entradasAnd[1] = new Entrada(30, 45);
		return entradasAnd;
	}
	public Saida[] pegaSaidas() {
		Saida[] saidasAnd = new Saida[1];
		saidasAnd[0] = new Saida(48, 35);
		return saidasAnd;	
	}

    int altura(){
        return 53;
    }

    int largura() {
        return 89;
    }

    void centralizaClique(Ponto ponto1, Ponto ponto2) {
        // Para centralizar dois pontos a partir do que foi informado no desenho. Faz sentido?
    	// Sim, só que seria melhor se fosse na porta lógica, não? Mais geral.
        int mediaAltura = this.altura()/2;
        int mediaLargura = this.largura()/2;
        ponto1.deslocarX(-(mediaLargura));
        ponto1.deslocarY(-(mediaAltura));
        ponto2.deslocarX(mediaLargura);
        ponto2.deslocarY(mediaAltura);
    }
}