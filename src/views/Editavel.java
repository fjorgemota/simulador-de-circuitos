package views;

import models.Sinal;

public interface Editavel extends Selecionavel {
    public void movePara(int x, int y);
    public void apaga();
    public void conectaSaida(Editavel saida);
    public void conectaEntrada(Editavel entrada);
    public void desconectaSaida(Editavel saida);
    public void desconectaEntrada(Editavel entrada);
    public void calcula();
    public Sinal pegaValor();
}
