package views;

import models.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FigXOR extends XOR implements Reproduzivel {
    public FigXOR(Ponto superiorEsquerdo) {
        super(superiorEsquerdo);
    }

    public void reproduzir(Graphics g) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File("imagens/xor.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a imagem: imagens/xor.png");
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
            g.setColor(Color.DARK_GRAY);
        } else {
            g.setColor(Color.LIGHT_GRAY);
        }
        for (int i = 0; i < saidas.length; i++) {
            g.fillOval(saidas[i].x0(), saidas[i].y0(), saidas[i].diametro(), saidas[i].diametro());
        }
        g.setColor(Color.BLACK);
    }
}
