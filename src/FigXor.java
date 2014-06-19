import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FigXor extends Xor implements Reproduzivel{
    FigXor(Ponto a, Ponto b){
        super(a,b);
    }
    public void reproduzir(Graphics g){
        BufferedImage image;
        try{
            image = ImageIO.read(new File("imagens/xor.png"));
        } catch(IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao carregar a imagem: imagens/xor.png");
            return;
        }
        g.drawImage(image, this.x(), this.y(), this.largura(), this.altura(), null);
    }
}
