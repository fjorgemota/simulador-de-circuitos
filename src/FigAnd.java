import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class FigAnd extends And implements Reproduzivel {
    BufferedImage image;
	FigAnd(Ponto a, Ponto b){
		super(a, b);
        try {
            image = ImageIO.read(new File("imagens/and.png"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem");
            return;
        }

	}
	public void reproduzir(Graphics g) {
        g.drawImage(image, this.x(), this.y(), null);

    }
}
