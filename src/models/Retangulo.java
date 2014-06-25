package models;

public class Retangulo {
    private Ponto ponto1, ponto2;

    public Retangulo(Ponto ponto1, Ponto ponto2){
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
