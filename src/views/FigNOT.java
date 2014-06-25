package views;

import models.Entrada;
import models.NOT;
import models.Ponto;
import models.Saida;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FigNOT extends NOT implements Reproduzivel {
    public FigNOT(Ponto a, Ponto b){
		super(a, b);
   	}
	public void reproduzir(Graphics g) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File("imagens/not.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: imagens/not.png");
            return;
        }
        g.drawImage(image, this.x(), this.y(), this.largura(), this.altura(), null);
        Entrada[] entradas = this.pegaEntradas();
        Saida[] saidas = this.pegaSaidas();
        g.setColor(Color.RED);
        for(int i=0; i<entradas.length; i++) {
            g.fillOval(this.x() + entradas[i].x0(), this.y() + entradas[i].y0(), entradas[i].diametro(), entradas[i].diametro());
        }
        g.setColor(Color.BLUE);
        for(int i=0; i<saidas.length; i++) {
            g.fillOval(this.x() + saidas[i].x0(), this.y() + saidas[i].y0(), saidas[i].diametro(), saidas[i].diametro());
        }
        g.setColor(Color.BLACK);
    }
}