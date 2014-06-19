class Xor extends PortaLogica {
    //private int numeroPortas;
    Xor(Ponto a, Ponto b){
        super(a,b);
        //this.numeroPortas = numeroPortas; [estipular no maximo doze entradas, talvez];
    }

    public Entrada[] pegaEntradas() {
        Entrada[] entradasXor = new Entrada[2];
        entradasXor[0] = new Entrada(251, 71);
        entradasXor[1] = new Entrada(251, 111);
        return entradasXor;
    }

        /*Entrada[] entradasXor = new Entrada[numeroPortas];
        for(int h = 0; h<entradasXor.length; h++) {
            for(int x = 71; x<Integer.MAX_VALUE; x+=30) {
                entradasXor[h] = new Entrada(251, x);
            }//cria o tanto de entradas especificadas;
        }
        return entradasXor;*/

    public Saida[] pegaSaidas(){
        Saida[] saidasXor = new Saida[1];
        saidasXor[0] = new Saida(325, 93);
        return saidasXor;
    }

    int altura(){
        return 53;
    }

    int largura(){
        return 83;
    }

    void centralizaClique(Ponto ponto1, Ponto ponto2){
        int mediaAltura = this.altura()/2;
        int mediaLargura = this.largura()/2;
        ponto1.deslocarY(-(mediaAltura));
        ponto1.deslocarX(-(mediaLargura));
        ponto2.deslocarY(mediaAltura);
        ponto2.deslocarX(mediaLargura);
    }
}
