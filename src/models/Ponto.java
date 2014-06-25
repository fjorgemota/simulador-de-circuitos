package models;

public class Ponto {
    private int x, y;

    public Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void deslocarX(int val) {
        this.x = this.x + val;
    }

    void deslocarY(int val) {
        this.y = this.y + val;
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    /**
     * Retorna a norma
     *
     * @return A norma
     */
    double distancia() {
        return this.distancia(new Ponto(0, 0));
    }

    double distancia(Ponto q) {
        double deltaX = Math.pow(this.x - q.x, 2);
        double deltaY = Math.pow(this.y - q.y, 2);
        return Math.sqrt(deltaX + deltaY);
    }

    int distanciaX(Ponto q) {
        int dis = this.x - q.x;
        if (dis < 0) {
            dis = -dis;
        }
        return dis;
    }

    int distanciaY(Ponto q) {
        int dis = this.y - q.y;
        if (dis < 0) {
            dis = -dis;
        }
        return dis;
    }

    int xesq(Ponto q) {
        int x0 = this.x;
        if(q.x < x0) return q.x;
        return x0;
    }

    int ysup(Ponto q) {
        int y0 = this.y;
        if(q.y < y0) return q.y;
        return y0;
    }

    int x0(int raio){
        return x - raio;
    }

    int y0(int raio){
        return y - raio;
    }
}