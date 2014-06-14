public class Retangulo {
    private Ponto ponto1, ponto2;

    Retangulo(Ponto ponto1, Ponto ponto2){
        this.ponto1 = ponto1;
        this.ponto2 = ponto2;
    }

    void deslocarX(int val){
        ponto1.deslocarX(val);
        ponto2.deslocarX(val);
    }
    void deslocarY(int val){
        ponto1.deslocarY(val);
        ponto2.deslocarY(val);
    }

    int x() {
        int x1 = this.ponto1.x;
        int x2 = this.ponto2.x;
        if (x1 > x2) {
            return x2;
        }
        else {
            return x1;
        }
    }

    int y() {
        int y1 = this.ponto1.y;
        int y2 = this.ponto2.y;
        if (y1 > y2) {
            return y2;
        }
        else {
            return y1;
        }
    }

    int largura(){
        return ponto1.distanciaX(ponto2);
    }

    int altura(){
        return ponto1.distanciaY(ponto2);
    }

    long area(){
        long b = this.largura();
        long h = this.altura();
        return (b*h);
    }

    long perimetro(){
        long l = this.largura()*2;
        long h = this.altura()*2;
        return l+h;
    }

}
