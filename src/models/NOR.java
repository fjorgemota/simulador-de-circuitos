package models;

public class NOR extends PortaLogica{
	public NOR(Ponto superiorEsquerdo){
		super(superiorEsquerdo);
	}

	public Entrada[] pegaEntradas() {
		Entrada[] entradasNOR = new Entrada[2];
		entradasNOR[0] = new Entrada(this, 3, 16);
		entradasNOR[1] = new Entrada(this, 3, 40);
		return entradasNOR;
	}
	public Saida[] pegaSaidas() {
		Saida[] saidasNOR = new Saida[1];
		saidasNOR[0] = new Saida(this, 87, 27);
		return saidasNOR;	
	}

    public int altura(){
        return 53;
    }

    public int largura() {
        return 89;
    }
}