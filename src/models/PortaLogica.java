package models;

import views.Editavel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class PortaLogica extends Retangulo implements Editavel {
    protected List<Editavel> entradas = new ArrayList<Editavel>();
    protected List<Editavel> saidas = new ArrayList<Editavel>();
    protected Sinal valor;


    protected PortaLogica(Ponto superiorEsquerdo) {
        super(superiorEsquerdo);
        this.centralizaClique();
    }

    public void apaga() {
        for(Editavel entrada: entradas) {
            Linha linha = (Linha) entrada;
            linha.desconectaSaida(this);
        }
        for(Editavel saida: saidas) {
            Linha linha = (Linha) saida;
            linha.desconectaEntrada(this);
        }
    }

    public void conectaSaida(Editavel saida) {
        this.saidas.add(saida);
    }

    public void conectaEntrada(Editavel entrada) {
        if (this.entradas.size() >= this.pegaEntradas().length) {
            JOptionPane.showMessageDialog(null, "Você não pode adicionar mais entradas a esta porta lógica");
            return;
        }
        this.entradas.add(entrada);
    }

    public void desconectaSaida(Editavel saida) {
        this.saidas.remove(saida);
    }

    public void desconectaEntrada(Editavel entrada) {
        this.entradas.remove(entrada);
    }

    public abstract void calcula();

    public Sinal pegaValor() {
        return this.valor;
    }


    // Porta logicas tambem tem entradas...
    public abstract Entrada[] pegaEntradas();

    // E saidas..
    public abstract Saida[] pegaSaidas();

    // Por ser uma imagem, portas logicas tem sempre a MESMA largura...
    abstract public int largura();

    // E tambem altura..
    abstract public int altura();

    // Desloca X e Y de forma que a porta logica apareca exatamente no meio do clique do usuario
    protected void centralizaClique() {
        int mediaAltura = this.altura() / 2;
        int mediaLargura = this.largura() / 2;
        this.deslocarX(-(mediaLargura));
        this.deslocarY(-(mediaAltura));
    }
}
