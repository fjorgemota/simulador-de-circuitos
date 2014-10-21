package models;

import views.Editavel;

public class NXOR extends PortaLogica {
    public NXOR(Ponto superiorEsquerdo) {
        super(superiorEsquerdo);
    }

    public Entrada[] pegaEntradas() {
        Entrada[] entradasNXOR = new Entrada[2];
        entradasNXOR[0] = new Entrada(this, 0, 13);
        entradasNXOR[1] = new Entrada(this, 0, 39);
        return entradasNXOR;
    }

    public Saida[] pegaSaidas() {
        Saida[] saidasNXOR = new Saida[1];
        saidasNXOR[0] = new Saida(this, 87, 26);
        return saidasNXOR;
    }

    public void calcula() {
        Sinal oldValor = this.valor;
        this.valor = Sinal.DESATIVADO;
        if (this.entradas.size() == 2) {
            Editavel entrada1 = this.entradas.get(0);
            Editavel entrada2 = this.entradas.get(1);
            this.valor = entrada1.pegaValor() != entrada2.pegaValor() ? Sinal.DESATIVADO : Sinal.ATIVADO;
        }
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