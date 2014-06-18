import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class FigAnd extends And implements Reproduzivel {
	FigAnd(Ponto a, Ponto b){
		super(a, b);
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

    }
}
