package models;

public class XOR extends PortaLogica {
    //private int numeroPortas;
    public XOR(Ponto a, Ponto b){
        super(a,b);
        //this.numeroPortas = numeroPortas; [estipular no maximo doze entradas, talvez];
    }

    public Entrada[] pegaEntradas() {
        Entrada[] entradasXor = new Entrada[2];
        entradasXor[0] = new Entrada(this, 0, 12);
        entradasXor[1] = new Entrada(this, 0, 37);
        return entradasXor;
    }

        /*models.Entrada[] entradasXor = new models.Entrada[numeroPortas];
        for(int h = 0; h<entradasXor.length; h++) {
            for(int x = 71; x<Integer.MAX_VALUE; x+=30) {
                entradasXor[h] = new models.Entrada(251, x);
            }//cria o tanto de entradas especificadas;
        }
        return entradasXor;*/

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
