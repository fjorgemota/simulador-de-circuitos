package models;

import java.io.Serializable;

public class Retangulo implements Serializable {
    private Ponto ponto1, ponto2;
    private int xSel, ySel; // Usados para guardar o x e y selecionados. Ver se ha melhor forma de fazer isso.
    public Retangulo() {}

    public Retangulo(Ponto ponto1, Ponto ponto2) {
        this.ponto1 = ponto1;
        this.ponto2 = ponto2;
    }

    public Retangulo(Ponto superiorEsquerdo) {
        this.ponto1 = superiorEsquerdo;
        this.ponto2 = new Ponto(superiorEsquerdo.x() + this.largura(), superiorEsquerdo.y() + this.altura());
    }

    public void deslocarX(int val) {
        ponto1.deslocarX(val);
        ponto2.deslocarX(val);
    }

    public void deslocarY(int val) {
        ponto1.deslocarY(val);
        ponto2.deslocarY(val);
    }

    public int x() {
        return this.ponto1.xesq(this.ponto2);
    }

    public int y() {
        return this.ponto1.ysup(this.ponto2);
    }

    public int largura() {
        return ponto1.distanciaX(ponto2);
    }

    public int altura() {
        return ponto1.distanciaY(ponto2);
    }

    public boolean contemPonto(int x, int y) {
        return this.x() <= x && (this.x() + this.largura()) >= x && this.y() <= y && (this.y() + this.altura()) >= y;
    }

    // Seleciona o retangulo
    public void selecionaPonto(int x, int y) {
        this.xSel = x - this.x();
        this.ySel = y - this.y();
    }

    public int getXSel() {
        return this.xSel + this.x();
    }

    public int getYSel() {
        return this.ySel + this.y();
    }

    // Move o ponto
    public void movePara(int x, int y) {
        x -= this.xSel;
        y -= this.ySel;
        this.deslocarX(x - this.x());
        this.deslocarY(y - this.y());
    }

}
