package models;


import views.Editavel;

public class Botao extends PortaLogica
{
    public Botao(Ponto superiorEsquerdo) {
        super(superiorEsquerdo);
    }

    public Entrada[] pegaEntradas() {
        Entrada[] entradasBotao = new Entrada[0];
        return entradasBotao;
    }

    public Saida[] pegaSaidas() {
        Saida[] saidasAnd = new Saida[1];
        saidasAnd[0] = new Saida(this, 10, 10, 10);
        return saidasAnd;
    }

    public void calcula() {
        this.valor = this.valor == Sinal.ATIVADO ? Sinal.DESATIVADO : Sinal.ATIVADO;
        for(Editavel saida: this.saidas) {
            saida.calcula();
        }
    }

    public int altura() {
        return 20;
    }

    public int largura() {
        return 20;
    }
}
