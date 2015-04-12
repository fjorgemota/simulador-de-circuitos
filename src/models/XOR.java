package models;

import views.Editavel;

public class XOR extends PortaLogica {
    //private int numeroPortas;
    public XOR(Ponto superiorEsquerdo) {
        super(superiorEsquerdo);
    }

    public Entrada[] pegaEntradas() {
        Entrada[] entradasXor = new Entrada[2];
        entradasXor[0] = new Entrada(this, 0, 12);
        entradasXor[1] = new Entrada(this, 0, 37);
        return entradasXor;
    }

    public void calcula() {
        Sinal oldValor = this.valor;
        this.valor = Sinal.DESATIVADO;
        if (this.entradas.size() == 2) {
            Editavel entrada1 = this.entradas.get(0);
            Editavel entrada2 = this.entradas.get(1);
            this.valor = entrada1.pegaValor() != entrada2.pegaValor() ? Sinal.ATIVADO: Sinal.DESATIVADO;
        }
        if (oldValor != this.valor) {
            for(Editavel saida: this.saidas) {
                saida.calcula();
            }
        }
    }

    public Saida[] pegaSaidas() {
        Saida[] saidasXor = new Saida[1];
        saidasXor[0] = new Saida(this, 80, 24);
        return saidasXor;
    }

    public int altura() {
        return 53;
    }

    public int largura() {
        return 83;
    }
}
