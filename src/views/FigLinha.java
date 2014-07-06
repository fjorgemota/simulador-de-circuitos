package views;

import models.Linha;

import java.awt.*;

public class FigLinha extends Linha implements Reproduzivel{
    public void reproduzir(Graphics g) {
        int[] x = x();
        int[] y = y();
        for(int i=0; i<npontos(); i++) {
            // Nos nao vamos desenhar o primeiro ponto pois afinal nao temos...pontos
            if(i > 0) {
                // O "+5" aqui e para centralizar a linha junto ao circulo
                g.drawLine(x[i - 1]+5, y[ i - 1]+5, x[i]+5, y[i]+5);
            }
            g.fillOval(x[i], y[i], 10, 10);
        }
    }
}