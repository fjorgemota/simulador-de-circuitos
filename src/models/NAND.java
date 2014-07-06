package models;

public class NAND extends PortaLogica{
    public NAND(Ponto a, Ponto b){
        super(a,b);
    }

    public Entrada[] pegaEntradas(){
        Entrada[] entradasNand = new Entrada[2];
        entradasNand[0] = new Entrada(this, 5, 12);
        entradasNand[1] = new Entrada(this, 5, 40);
        return entradasNand;
    }

    public Saida[] pegaSaidas(){
        Saida[] saidasNand = new Saida[1];
        saidasNand[0] = new Saida(this, 89, 26);
        return saidasNand;
    }
    public int largura() {
        return 53;
    }

    public int altura() {
        return 89;
    }

    void centralizaClique(Ponto ponto1, Ponto ponto2) {
        int mediaLargura = this.largura()/2;
        int mediaAltura = this.altura()/2;
        ponto1.deslocarX(-(mediaLargura));
        ponto1.deslocarY(-(mediaAltura));
        ponto2.deslocarX(mediaLargura);
        ponto2.deslocarY(mediaAltura);
    }
}
