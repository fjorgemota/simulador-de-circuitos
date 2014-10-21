package models;

import views.Editavel;

public class NOT extends PortaLogica {
    public NOT(Ponto superiorEsquerdo) {
        super(superiorEsquerdo);
    }

    public Entrada[] pegaEntradas() {
        Entrada[] entradasNOT = new Entrada[1];
        entradasNOT[0] = new Entrada(this, 7, 26);
        return entradasNOT;
    }

    public Saida[] pegaSaidas() {
        Saida[] saidasNOT = new Saida[1];
        saidasNOT[0] = new Saida(this, 85, 25);
        return saidasNOT;
    }

    public void calcula() {
        Sinal oldValor = this.valor;
        this.valor = Sinal.DESATIVADO;
        for(Editavel entrada: this.entradas) {
            if(entrada.pegaValor() == Sinal.ATIVADO) {
                this.valor = Sinal.ATIVADO;
                break;
            }
        }
        this.valor = this.valor == Sinal.ATIVADO ? Sinal.DESATIVADO : Sinal.ATIVADO;
        if (oldValor != this.valor) {
            for(Editavel saida: this.saidas) {
                saida.calcula();
            }
        }
    }

    public int altura() {
        return 53;
    }

    public int largura() {
        return 89;
    }
}