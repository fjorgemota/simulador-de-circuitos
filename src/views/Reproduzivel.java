package views;

import java.awt.*;

public interface Reproduzivel {
    public void reproduzir(Graphics g);
    public boolean contemPonto(int x, int y);
    public void selecionaPonto(int x, int y);
    public void movePara(int x, int y);
}
