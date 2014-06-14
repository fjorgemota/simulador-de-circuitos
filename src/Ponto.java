class Ponto {
    protected int x, y;

    Ponto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    Ponto(int z) {
        this(z, z);
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

    int x0(int raio){
        return x - raio;
    }

    int y0(int raio){
        return y - raio;
    }
}