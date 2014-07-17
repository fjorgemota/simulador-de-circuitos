package models;

public abstract class PortaLogica extends Retangulo{
    protected PortaLogica(Ponto superiorEsquerdo) {
        super(superiorEsquerdo);
        this.centralizaClique();
    }

    // Porta logicas tambem tem entradas...
    public abstract Entrada[] pegaEntradas();

    // E saidas..
    public abstract Saida[] pegaSaidas();

    // Por ser uma imagem, portas logicas tem sempre a MESMA largura...
    abstract public int largura();

    // E tambem altura..
    abstract public int altura();

    // Desloca X e Y de forma que a porta logica apaerca exatamente no meio do clique do usuario
    protected void centralizaClique() {
        int mediaAltura = this.altura()/2;
        int mediaLargura = this.largura()/2;
        this.deslocarX(-(mediaLargura));
        this.deslocarY(-(mediaAltura));
    }
}
