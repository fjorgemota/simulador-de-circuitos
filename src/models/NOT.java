package models;

public class NOT extends PortaLogica{
	public NOT(Ponto a, Ponto b){
		super(a, b);
	}

	public Entrada[] pegaEntradas() {
		Entrada[] entradasNOT = new Entrada[1];
		entradasNOT[0] = new Entrada(this, 7, 26);
		return entradasNOT;
	}
	public Saida[] pegaSaidas() {
		Saida[] saidasNOT = new Saida[1];
		saidasNOT[0] = new Saida(this, 85, 25);
		return saidasNOT;	
	}

    public int altura(){
        return 53;
    }

    public int largura() {
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