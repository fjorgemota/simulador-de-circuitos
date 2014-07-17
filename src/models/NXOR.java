package models;

public class NXOR extends PortaLogica{
	public NXOR(Ponto superiorEsquerdo){
		super(superiorEsquerdo);
	}

	public Entrada[] pegaEntradas() {
		Entrada[] entradasNXOR = new Entrada[2];
		entradasNXOR[0] = new Entrada(this, 0, 13);
		entradasNXOR[1] = new Entrada(this, 0, 39);
		return entradasNXOR;
	}
	public Saida[] pegaSaidas() {
		Saida[] saidasNXOR = new Saida[1];
		saidasNXOR[0] = new Saida(this, 87, 26);
		return saidasNXOR;	
	}

    public int altura(){
        return 53;
    }

    public int largura() {
        return 89;
    }
}