package models;

public class AND extends PortaLogica{
	public AND(Ponto superiorEsquerdo){
		super(superiorEsquerdo);
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
}