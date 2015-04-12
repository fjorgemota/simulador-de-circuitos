package views;

import java.awt.*;

public interface Reproduzivel extends Editavel {
    public void reproduzir(Graphics g);
    public int x();
    public int y();
    public int largura();
    public int altura();

}
