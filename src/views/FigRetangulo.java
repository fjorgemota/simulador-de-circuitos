package views;

import models.Retangulo;
import models.Ponto;

import java.awt.*;

public class FigRetangulo extends Retangulo implements Reproduzivel {
    public FigRetangulo(Ponto ponto1, Ponto ponto2) {
        super(ponto1, ponto2);
    }
    public void reproduzir(Graphics g){
        g.drawRect(this.x(), this.y(), this.largura(), this.altura());
    }
}
