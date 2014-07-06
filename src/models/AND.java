package models;

public class AND extends PortaLogica{
	public AND(Ponto a, Ponto b){
		super(a, b);
	}

	public Entrada[] pegaEntradas() {
		Entrada[] entradasAnd = new Entrada[2];
		entradasAnd[0] = new Entrada(this, 0, 13);
		entradasAnd[1] = new Entrada(this, 0, 39);
		return entradasAnd;
	}
	public Saida[] pegaSaidas() {
		Saida[] saidasAnd = new Saida[1];
		saidasAnd[0] = new Saida(this, 87, 26);
		return saidasAnd;	
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