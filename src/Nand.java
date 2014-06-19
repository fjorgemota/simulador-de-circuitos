public class Nand extends PortaLogica{
    public Nand (Ponto a, Ponto b){
        super(a,b);
    }

    public Entrada[] pegaEntradas(){
        Entrada[] entradasNand = new Entrada[2];
        entradasNand[0] = new Entrada(30, 25);
        entradasNand[1] = new Entrada(30, 45);
        return entradasNand;
    }

    public Saida[] pegaSaidas(){
        Saida[] saidasNand = new Saida[1];
        saidasNand[0] = new Saida(48, 35);
        return saidasNand;
    }
    int largura() {
        return 53;
    }

    int altura() {
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
