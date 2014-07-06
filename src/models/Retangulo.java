package models;

import views.Editavel;
import views.Selecionavel;

public class Retangulo implements Editavel {
    private Ponto ponto1, ponto2;
    private int xSel, ySel; // Usados para guardar o x e y selecionados. Ver se ha melhor forma de fazer isso.
    public Retangulo(Ponto ponto1, Ponto ponto2){
        this.ponto1 = ponto1;
        this.ponto2 = ponto2;
    }

    public void deslocarX(int val){
        ponto1.deslocarX(val);
        ponto2.deslocarX(val);
    }
    public void deslocarY(int val){
        ponto1.deslocarY(val);
        ponto2.deslocarY(val);
    }

    public int x() {
        return this.ponto1.xesq(this.ponto2);
    }

    public int y() {
       return this.ponto1.ysup(this.ponto2);
    }

    public int largura(){
        return ponto1.distanciaX(ponto2);
    }

    public int altura(){
        return ponto1.distanciaY(ponto2);
    }

    public boolean contemPonto(int x, int y) {
        return this.x() <= x && (this.x() + this.largura()) >= x && this.y() <= y && (this.y()+this.altura()) >= y;
    }

    // Seleciona o retangulo
    public void selecionaPonto(int x, int y) {
        this.xSel = x-this.x();
        this.ySel = y-this.y();
    }

    // Move o ponto
    public void movePara(int x, int y){
        x -= this.xSel;
        y -= this.ySel;
        this.deslocarX(x - this.x());
        this.deslocarY(y - this.y());
    }

}
