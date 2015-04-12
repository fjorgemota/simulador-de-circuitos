package views;

import models.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class FigNOT extends NOT implements Reproduzivel {
    public FigNOT(Ponto superiorEsquerdo) {
        super(superiorEsquerdo);
    }

    public void reproduzir(Graphics g) {
        BufferedImage image;
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("imagens/not.png");
            image = ImageIO.read(input);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: imagens/not.png");
            return;
        }
        g.drawImage(image, this.x(), this.y(), this.largura(), this.altura(), null);
        Entrada[] entradas = this.pegaEntradas();
        Saida[] saidas = this.pegaSaidas();
        g.setColor(Color.RED);
        for (int i = 0; i < entradas.length; i++) {
            g.fillOval(entradas[i].x0(), entradas[i].y0(), entradas[i].diametro(), entradas[i].diametro());
        }
        if (this.valor == Sinal.ATIVADO) {
            g.setColor(Color.YELLOW);
            for (int i = 0; i < saidas.length; i++) {
                g.fillOval(saidas[i].x0(), saidas[i].y0(), saidas[i].diametro(), saidas[i].diametro());
            }
        } else {
            g.setColor(Color.BLACK);
            for (int i = 0; i < saidas.length; i++) {
                g.drawOval(saidas[i].x0(), saidas[i].y0(), saidas[i].diametro(), saidas[i].diametro());
            }
        }
        g.setColor(Color.BLACK);
    }
}