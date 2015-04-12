package views;

import models.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FigBotao extends Botao implements Reproduzivel {
    public FigBotao(Ponto superiorEsquerdo) {
        super(superiorEsquerdo);
    }

    public void reproduzir(Graphics g) {
        g.drawRect(this.x(), this.y(), this.largura(), this.altura());
        if (this.valor == Sinal.ATIVADO) {
            g.setColor(Color.YELLOW);
            g.fillOval(this.x(), this.y(), this.largura(), this.altura());
        } else {
            g.setColor(Color.BLACK);
            g.drawOval(this.x(), this.y(), this.largura(), this.altura());
        }
        g.setColor(Color.BLACK);
    }
}
