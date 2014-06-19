class OR extends PortaLogica{
	OR(Ponto a, Ponto b){
		super(a, b);
	}

	public Entrada[] pegaEntradas() {
		Entrada[] entradasOR = new Entrada[2];
		entradasOR[0] = new Entrada(175, 70);
		entradasOR[1] = new Entrada(175, 100);
		return entradasOR;
	}
	public Saida[] pegaSaidas() {
		Saida[] saidasOR = new Saida[1];
		saidasOR[0] = new Saida(375, 85);
		return saidasOR;	
	}

    int altura(){
        return 53;
    }

    int largura() {
        return 89;
    }

    void centralizaClique(Ponto ponto1, Ponto ponto2) {
        // Para centralizar dois pontos a partir do que foi informado no desenho. Faz sentido?
    	// Sim, só que não seria melhor se fosse na porta lógica? Mais geral.
        int mediaAltura = this.altura()/2;
        int mediaLargura = this.largura()/2;
        ponto1.deslocarX(-(mediaLargura));
        ponto1.deslocarY(-(mediaAltura));
        ponto2.deslocarX(mediaLargura);
        ponto2.deslocarY(mediaAltura);
    }
}