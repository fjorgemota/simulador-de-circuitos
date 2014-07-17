package views;

import models.AND;
import models.Entrada;
import models.Ponto;
import models.Saida;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FigAND extends AND implements Reproduzivel {
    public FigAND(Ponto superiorEsquerdo){
		super(superiorEsquerdo);
   	}
	public void reproduzir(Graphics g) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File("imagens/and.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: imagens/and.png");
            return;
        }
        g.drawImage(image, this.x(), this.y(), this.largura(), this.altura(), null);
        Entrada[] entradas = this.pegaEntradas();
        Saida[] saidas = this.pegaSaidas();
        g.setColor(Color.RED);
        for(int i=0; i<entradas.length; i++) {
            g.fillOval(entradas[i].x0(), entradas[i].y0(), entradas[i].diametro(), entradas[i].diametro());
        }
        g.setColor(Color.BLUE);
        for(int i=0; i<saidas.length; i++) {
            g.fillOval(saidas[i].x0(), saidas[i].y0(), saidas[i].diametro(), saidas[i].diametro());
        }
        g.setColor(Color.BLACK);
    }
}
