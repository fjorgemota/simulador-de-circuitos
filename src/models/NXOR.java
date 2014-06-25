package models;

public class NXOR extends PortaLogica{
	public NXOR(Ponto a, Ponto b){
		super(a, b);
	}

	public Entrada[] pegaEntradas() {
		Entrada[] entradasNXOR = new Entrada[2];
		entradasNXOR[0] = new Entrada(0, 13);
		entradasNXOR[1] = new Entrada(0, 39);
		return entradasNXOR;
	}
	public Saida[] pegaSaidas() {
		Saida[] saidasNXOR = new Saida[1];
		saidasNXOR[0] = new Saida(87, 26);
		return saidasNXOR;	
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