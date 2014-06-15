class And extends PortaLogica{
	And(Ponto a, Ponto b){
		super(a, b);
		
	}
	public Entrada[] pegaEntradas() {
		Entrada[] entradasAnd = new Entrada[2];
		entradasAnd[0] = new Entrada(100, 50);
		entradasAnd[1] = new Entrada(100, 100);
		return entradasAnd;
	}
	public Saida[] pegaSaidas() {
		Saida[] saidasAnd = new Saida[1];
		saidasAnd[0] = new Saida(300, 75);
		return saidasAnd;	
	}
}