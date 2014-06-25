package models;

class Circulo extends Ponto {
    private int raio;

    Circulo(int x, int y, int raio) {
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
}
