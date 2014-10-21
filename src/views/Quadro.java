package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Quadro extends JPanel {
    private java.util.List<Reproduzivel> fig = new ArrayList<Reproduzivel>();

    public void addFig(Reproduzivel fig) {
        this.fig.add(fig);
    }

    public void removeFig(Reproduzivel fig) {
        fig.apaga();
        this.fig.remove(fig);
    }

    public Reproduzivel pegaObjetoEm(int x, int y) {
        for (int i = 0; i < fig.size(); i++) {
            if (fig.get(i).contemPonto(x, y)) {
                return fig.get(i);
            }
        }
        return null;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // paintComponent redesenha o painel
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        for (int i = 0; i < fig.size(); i++) {
            fig.get(i).reproduzir(g);
        }
    }
}