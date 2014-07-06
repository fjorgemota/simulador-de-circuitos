package models;

import views.Editavel;

public class Circulo extends Ponto implements Editavel{
    private int raio;
    private int xSel, ySel;

    public Circulo(int x, int y, int raio) {
        super(x,y);
        this.raio = raio;
    }

    public int diametro() {
        return 2*raio;
    }

    public int x0() {
        return this.x0(raio);
    }
    public int y0() {
        return this.y0(raio);
    }

    public boolean contemPonto(int x, int y) {
        return this.x0() <= x && (this.x0() + this.diametro()) >= x && this.y0() <= y && (this.y0()+this.diametro()) >= y;
    }

    // Seleciona o retangulo
    public void selecionaPonto(int x, int y) {
        this.xSel = x-this.x0();
        this.ySel = y-this.y0();
    }

    // Move o ponto
    public void movePara(int x, int y){
        x -= this.xSel;
        y -= this.ySel;
        this.deslocarX(x - this.x0());
        this.deslocarY(y - this.y0());
    }
}
