package models;

import views.Editavel;

public class NAND extends PortaLogica {
    public NAND(Ponto superiorEsquerdo) {
        super(superiorEsquerdo);
    }

    public Entrada[] pegaEntradas() {
        Entrada[] entradasNand = new Entrada[2];
        entradasNand[0] = new Entrada(this, 5, 12);
        entradasNand[1] = new Entrada(this, 5, 40);
        return entradasNand;
    }

    public Saida[] pegaSaidas() {
        Saida[] saidasNand = new Saida[1];
        saidasNand[0] = new Saida(this, 89, 26);
        return saidasNand;
    }

    public void calcula() {
        Sinal oldValor = this.valor;
        this.valor = this.entradas.isEmpty() ? Sinal.DESATIVADO : Sinal.ATIVADO;
        for(Editavel entrada: this.entradas) {
            if (entrada.pegaValor() == Sinal.DESATIVADO) {
                this.valor = Sinal.DESATIVADO;
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

    public int largura() {
        return 53;
    }

    public int altura() {
        return 89;
    }
}
