class NOR extends PortaLogica{
	NOR(Ponto a, Ponto b){
		super(a, b);
	}

	public Entrada[] pegaEntradas() {
		Entrada[] entradasNOR = new Entrada[2];
		entradasNOR[0] = new Entrada(30, 25);
		entradasNOR[1] = new Entrada(30, 45);
		return entradasNOR;
	}
	public Saida[] pegaSaidas() {
		Saida[] saidasNOR = new Saida[1];
		saidasNOR[0] = new Saida(48, 35);
		return saidasNOR;	
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