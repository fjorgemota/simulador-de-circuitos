package views;

import models.Circulo;
import models.Linha;
import models.Ponto;
import models.Sinal;

import java.awt.*;

public class FigLinha extends Linha implements Reproduzivel {
    public void reproduzir(Graphics g) {
        if (this.valor == Sinal.ATIVADO) {
            g.setColor(Color.YELLOW);
        } else {
            g.setColor(Color.LIGHT_GRAY);
        }
        Circulo pontoAnterior = null;
        for (Circulo ponto: pontos()) {
            // Nos nao vamos desenhar o primeiro ponto pois afinal nao temos...pontos
            if (pontoAnterior != null) {
                // O "+5" aqui e para centralizar a linha junto ao circulo
                g.drawLine(pontoAnterior.x0() + 5, pontoAnterior.y0() + 5, ponto.x0() + 5, ponto.y0() + 5);
            }
            g.fillOval(ponto.x0(), ponto.y0(), 10, 10);
            pontoAnterior = ponto;
        }
        g.setColor(Color.BLACK);
    }
}
