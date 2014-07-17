package models;

public class NAND extends PortaLogica{
    public NAND(Ponto superiorEsquerdo){
        super(superiorEsquerdo);
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
}
