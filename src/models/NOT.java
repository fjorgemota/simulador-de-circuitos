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
}