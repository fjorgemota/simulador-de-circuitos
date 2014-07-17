package models;

public class OR extends PortaLogica{
	public OR(Ponto superiorEsquerdo){
		super(superiorEsquerdo);
	}

	public Entrada[] pegaEntradas() {
		Entrada[] entradasOR = new Entrada[2];
		entradasOR[0] = new Entrada(this, 5, 15);
		entradasOR[1] = new Entrada(this, 5, 37);
		return entradasOR;
	}
	public Saida[] pegaSaidas() {
		Saida[] saidasOR = new Saida[1];
		saidasOR[0] = new Saida(this, 85, 26);
		return saidasOR;	
	}

    public int altura(){
        return 53;
    }

    public int largura() {
        return 89;
    }
}