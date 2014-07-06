package models;

import models.Ponto;

import java.util.ArrayList;
import java.util.List;

public class Linha {
    private List<Circulo> pontos = new ArrayList<Circulo>();
    private Circulo pontoSelecionado = null; // Guarda o ponto selecionado da linha. Ver se ha melhor forma de fazer isso.

    public int[] x() {
        int[] x = new int[npontos()];
        for(int i=0, l = npontos(); i < l; i++) {
            x[i] = pontos.get(i).x0();
        }
        return x;
    }

    public int[] y() {
        int[] y = new int[npontos()];
        for(int i=0, l = npontos(); i < l; i++) {
            y[i] = pontos.get(i).y0();
        }
        return y;
    }

    public Circulo[] pontos(){
        Circulo[] resultado = new Circulo[pontos.size()];
        for(int i=0; i<pontos.size(); i++) {
            resultado[i] = pontos.get(i);
        }
        return resultado;
    }

    public int npontos(){
        return pontos.size();
    }

    public boolean contemPonto(int x, int y){
        for(int i=0; i < npontos(); i++) {
            if(pontos.get(i).contemPonto(x, y)) {
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
        for(int i=0; i < npontos(); i++) {
            if(pontos.get(i).contemPonto(x, y)) {
                this.pontoSelecionado = pontos.get(i);
                break;
            }
        }
    }

    // Move o ponto selecionado
    public void movePara(int x, int y){
        if(this.pontoSelecionado != null) {
            this.pontoSelecionado.deslocarX(x - this.pontoSelecionado.x0());
            this.pontoSelecionado.deslocarY(y - this.pontoSelecionado.y0());
        }
    }
}
