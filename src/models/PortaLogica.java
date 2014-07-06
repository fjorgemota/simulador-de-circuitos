package models;

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
    abstract public int largura();

    // E tambem altura..
    abstract public int altura();

    protected void centralizaClique(Ponto ponto1, Ponto ponto2) {
        int mediaAltura = this.altura()/2;
        int mediaLargura = this.largura()/2;
        ponto1.deslocarX(-(mediaLargura));
        ponto1.deslocarY(-(mediaAltura));
        ponto2.deslocarX(mediaLargura);
        ponto2.deslocarY(mediaAltura);
    }
}
