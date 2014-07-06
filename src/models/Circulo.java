package models;

public class Circulo extends Ponto {
    private int raio;

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
}
