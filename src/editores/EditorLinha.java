package editores;

import models.*;
import views.FigLinha;
import views.Quadro;
import views.Reproduzivel;

import javax.swing.*;

public class EditorLinha implements Editor {
    private Quadro quadro;
    private FigLinha linha;
    private int nEstado = 0;

    public EditorLinha(Quadro quadro) {
        this.quadro = quadro;
    }

    private boolean verificaClique(Circulo circ, int x, int y) {
        boolean match = false;
        int margin = 5;
        for(int xVerify=x-margin; xVerify <= (x+margin); xVerify++) {
            for(int yVerify=y-margin; yVerify <= (y+margin); yVerify++) {
                if(match) {
                    break;
                }
                match = circ.contemPonto(xVerify, yVerify);
            }
        }
        return match;
    }
    public void clique(int x, int y) {
        Circulo circulo = null;
        Reproduzivel figura = this.quadro.pegaObjetoEm(x, y);
        if (nEstado == 0) {
            linha = new FigLinha();
            this.quadro.addFig(linha);
            if (figura == null) {
                JOptionPane.showMessageDialog(null, "Selecione um ponto em um conector ou saida em uma porta logica!");
                return;
            } else if (figura instanceof PortaLogica) { // Se o objeto selecionado for uma PortaLogica...
                PortaLogica porta = (PortaLogica) figura;
                Saida[] saidas = porta.pegaSaidas();
                for (int i = 0; i < saidas.length; i++) {
                    if (this.verificaClique(saidas[i], x, y)) {
                        circulo = saidas[i];
                        break;
                    }
                }
                if (circulo == null) {
                    JOptionPane.showMessageDialog(null, "Selecione a saida da porta logica!");
                    return;
                }
                porta.conectaSaida(linha);
                linha.conectaEntrada(porta);
            } else if (figura instanceof Linha) { // Se o objeto selecionado for uma Linha...
                Linha novaLinha = (Linha) figura;
                Circulo[] pontos = novaLinha.pontos();
                for (int i = 0; i < pontos.length; i++) {
                    if (this.verificaClique(pontos[i], x, y)) {
                        circulo = pontos[i];
                        break;
                    }
                }
                novaLinha.conectaSaida(linha);
                linha.conectaEntrada(novaLinha);
            }
            linha.addPonto(circulo);
            nEstado = 1;
        } else if (nEstado == 1) {
            if (figura == null) {
                circulo = new Circulo(x, y, 5);
            } else if (figura instanceof PortaLogica) {
                PortaLogica porta = (PortaLogica) figura;
                Entrada[] entradas = porta.pegaEntradas();
                for (int i = 0; i < entradas.length; i++) {
                    if (this.verificaClique(entradas[i], x, y)) {
                        circulo = entradas[i];
                        break;
                    }
                }
                if (circulo == null) {
                    JOptionPane.showMessageDialog(null, "Selecione uma entrada se você deseja conectar o cabo a esta porta lógica!");
                    return;
                } else if (linha.npontos() > 1) {
                    porta.conectaEntrada(linha);
                    linha.conectaSaida(porta);
                    nEstado = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, adicione pelo menos mais um ponto antes de conectar este cabo diretamente a uma porta lógica!");
                    return;
                }
            } else if (figura instanceof Linha) {
                Linha linhaSelecionada = (Linha) figura;
                Circulo[] pontos = linhaSelecionada.pontos();
                for (int i = 0; i < pontos.length; i++) {
                    if (this.verificaClique(pontos[i], x, y)) {
                        circulo = pontos[i];
                        break;
                    }
                }
                if (linha.npontos() > 1) {
                    linhaSelecionada.conectaEntrada(linha);
                    linha.conectaSaida(linhaSelecionada);
                    nEstado = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, adicione pelo menos mais um ponto antes de conectar este cabo diretamente a uma outro cabo!");
                    return;
                }
            }
            linha.addPonto(circulo);
        }
        this.quadro.repaint();
    }
}
