import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FigNand extends Nand implements Reproduzivel{
    FigNand(Ponto a, Ponto b){
        super(a , b);
    }
    public void reproduzir(Graphics g){
        BufferedImage image;
        try {
            image = ImageIO.read(new File("imagens/nand.png"));
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao carregar imagem: imagens/nand.png");
            return;
        }
        g.drawImage(image, this.x(), this.y(), this.altura(), this.largura(), null);
    }
}
