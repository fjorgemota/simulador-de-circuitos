package models;

public class XOR extends PortaLogica {
    //private int numeroPortas;
    public XOR(Ponto superiorEsquerdo){
        super(superiorEsquerdo);
    }

    public Entrada[] pegaEntradas() {
        Entrada[] entradasXor = new Entrada[2];
        entradasXor[0] = new Entrada(this, 0, 12);
        entradasXor[1] = new Entrada(this, 0, 37);
        return entradasXor;
    }

    public Saida[] pegaSaidas(){
        Saida[] saidasXor = new Saida[1];
        saidasXor[0] = new Saida(this, 80, 24);
        return saidasXor;
    }

    public int altura(){
        return 53;
    }

    public int largura(){
        return 83;
    }
}
