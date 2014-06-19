public abstract class PortaLogica extends Retangulo{
    protected PortaLogica(Ponto ponto1, Ponto ponto2) {
        super(ponto1, ponto2);
        this.centralizaClique(ponto1, ponto2);
    }

    // Porta logicas tambem tem entradas...
    public abstract Entrada[] pegaEntradas();

    // E saidas..
    public abstract Saida[] pegaSaidas();

    // Por ser uma imagem, portas logicas tem sempre a MESMA largura...
    abstract int largura();

    // E tambem altura..
    abstract int altura();

    // E, por padrao, devem aparecer de forma centralizada no painel
    abstract void centralizaClique(Ponto ponto1, Ponto ponto2);
}
