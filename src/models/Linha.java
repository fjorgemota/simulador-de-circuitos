package models;

import views.Editavel;
import views.Reproduzivel;

import java.util.ArrayList;
import java.util.List;

public class Linha implements Editavel {
    private List<Circulo> pontos = new ArrayList<Circulo>();
    private Circulo pontoSelecionado = null; // Guarda o ponto selecionado da linha. Ver se ha melhor forma de fazer isso.
    protected List<Editavel> entradas = new ArrayList<Editavel>();
    protected List<Editavel> saidas = new ArrayList<Editavel>();
    protected Sinal valor = Sinal.DESATIVADO;

    public void apaga() {
        for(Editavel entrada: entradas) {
            if (entrada instanceof PortaLogica) {
                PortaLogica porta = (PortaLogica) entrada;
                porta.desconectaSaida(this);
            } else if(entrada instanceof Linha) {
                Linha linha = (Linha) entrada;
                linha.desconectaSaida(this);
            }
        }
        for(Editavel saida: saidas) {
            if (saida instanceof PortaLogica) {
                PortaLogica porta = (PortaLogica) saida;
                porta.desconectaEntrada(this);
            } else if(saida instanceof Linha) {
                Linha linha = (Linha) saida;
                linha.desconectaEntrada(this);
            }
        }
    }

    public void conectaSaida(Editavel saida) {
        this.saidas.add(saida);
    }

    public void conectaEntrada(Editavel entrada) {
        this.entradas.add(entrada);
    }

    public void desconectaSaida(Editavel saida) {
        this.saidas.remove(saida);
    }

    public void desconectaEntrada(Editavel entrada) {
        this.entradas.remove(entrada);
    }

    public void calcula(){
        Sinal oldValor = this.valor;
        this.valor = Sinal.DESATIVADO;
        for(Editavel entrada: this.entradas) {
            if (entrada.pegaValor() == Sinal.ATIVADO) {
                this.valor = Sinal.ATIVADO;
                break;
            }
        }
        if (oldValor != this.valor) {
            for(Editavel saida: this.saidas) {
                saida.calcula();
            }
        }
    }

    public Sinal pegaValor() {
        return this.valor;
    }

    public int[] x() {
        int[] x = new int[npontos()];
        for (int i = 0, l = npontos(); i < l; i++) {
            x[i] = pontos.get(i).x0();
        }
        return x;
    }

    public int[] y() {
        int[] y = new int[npontos()];
        for (int i = 0, l = npontos(); i < l; i++) {
            y[i] = pontos.get(i).y0();
        }
        return y;
    }

    public Circulo[] pontos() {
        Circulo[] resultado = new Circulo[pontos.size()];
        for (int i = 0; i < pontos.size(); i++) {
            resultado[i] = pontos.get(i);
        }
        return resultado;
    }

    public int npontos() {
        return pontos.size();
    }

    public boolean contemPonto(int x, int y) {
        for (int i = 0; i < npontos(); i++) {
            if (pontos.get(i).contemPonto(x, y)) {
                return true;
            }
        }
        return false;
    }

    public void addPonto(Circulo ponto) {
        pontos.add(ponto);
    }

    // Seleciona o ponto
    public void selecionaPonto(int x, int y) {
        for (int i = 0; i < npontos(); i++) {
            if (pontos.get(i).contemPonto(x, y)) {
                this.pontoSelecionado = pontos.get(i);
                this.pontoSelecionado.selecionaPonto(x, y);
                break;
            }
        }
    }

    // Move o ponto selecionado
    public void movePara(int x, int y) {
        if (this.pontoSelecionado != null) {
            this.pontoSelecionado.movePara(x, y);
        }
    }
}
