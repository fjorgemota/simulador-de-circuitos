package editores;

import models.*;
import views.FigLinha;
import views.Modo;
import views.Quadro;
import views.Reproduzivel;

import javax.swing.*;

public class EditorLinha implements Editor{
    private Quadro quadro;
    private FigLinha linha;
    private int nEstado = 0;
    public EditorLinha(Quadro quadro) {
        this.quadro = quadro;
    }

    public void clique(int x, int y){
        Circulo circulo = null;
        Reproduzivel figura = this.quadro.pegaObjetoEm(x, y);
        if(nEstado == 0) {
            linha = new FigLinha();
            this.quadro.addFig(linha);
            if(figura == null) {
                JOptionPane.showMessageDialog(null, "Selecione um ponto em um conector ou saida em uma porta logica!");
                return;
            }
            else if (figura instanceof PortaLogica) { // Se o objeto selecionado for uma PortaLogica...
                PortaLogica porta = (PortaLogica) figura;
                Saida[] saidas = porta.pegaSaidas();
                for(int i=0; i < saidas.length; i++){
                    if(saidas[i].contemPonto(x, y)) {
                        circulo = saidas[i];
                        break;
                    }
                }
                if (circulo == null) {
                    JOptionPane.showMessageDialog(null, "Selecione a saida da porta logica!");
                    return;
                }
            }
            else if(figura instanceof Linha) { // Se o objeto selecionado for uma Linha...
                Linha linha = (Linha) figura;
                Circulo[] pontos = linha.pontos();
                for(int i=0; i<pontos.length; i++) {
                    if(pontos[i].contemPonto(x, y)) {
                        circulo = pontos[i];
                        break;
                    }
                }
            }
            linha.addPonto(circulo);
            nEstado = 1;
        }
        else if(nEstado == 1) {
            if (figura == null) {
                circulo = new Circulo(x, y, 5);
            }
            else if (figura instanceof PortaLogica) {
                PortaLogica porta = (PortaLogica) figura;
                Entrada[] entradas = porta.pegaEntradas();
                for (int i = 0; i < entradas.length; i++) {
                    if (entradas[i].contemPonto(x, y)) {
                        circulo = entradas[i];
                        break;
                    }
                }
                if(circulo == null) {
                    JOptionPane.showMessageDialog(null, "Selecione uma entrada se você deseja conectar o cabo a esta porta lógica!");
                }
                else if(linha.npontos() > 1) {
                    nEstado = 0;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Por favor, adicione pelo menos mais um ponto antes de conectar este cabo diretamente a uma porta lógica!");
                    return;
                }
            }
            else if(figura instanceof Linha) {
                Linha linhaSelecionada = (Linha) figura;
                Circulo[] pontos = linhaSelecionada.pontos();
                for(int i=0; i<pontos.length; i++) {
                    if(pontos[i].contemPonto(x, y)) {
                        circulo = pontos[i];
                        break;
                    }
                }
                if(linha.npontos() > 1) {
                    nEstado = 0;
                }
                else {
                    JOptionPane.showMessageDialog(null, "Por favor, adicione pelo menos mais um ponto antes de conectar este cabo diretamente a uma outro cabo!");
                    return;
                }
            }
            linha.addPonto(circulo);
        }
        this.quadro.repaint();
    }
}
