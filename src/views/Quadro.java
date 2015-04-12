package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Quadro extends JPanel {
    private ArrayList<Reproduzivel> fig = new ArrayList<Reproduzivel>();

    public void addFig(Reproduzivel fig) {
        this.fig.add(fig);
    }

    public void removeFig(Reproduzivel fig) {
        fig.apaga();
        this.fig.remove(fig);
    }

    public ArrayList<Reproduzivel> getFigs() {
        return fig;
    }

    public void setFigs(ArrayList<Reproduzivel> figs) {
        this.fig = figs;
        this.repaint();
    }

    private boolean verificaObjetoEm(Reproduzivel obj, int x, int y) {
        boolean match = false;
        int margin = 10;
        for(int xVerify=x-margin; xVerify <= (x+margin); xVerify++) {
            for(int yVerify=y-margin; yVerify <= (y+margin); yVerify++) {
                if(match) {
                    break;
                }
                match = obj.contemPonto(xVerify, yVerify);
            }
        }
        return match;
    }

    public Reproduzivel pegaObjetoEm(int x, int y) {
        for (int i = 0; i < fig.size(); i++) {
            Reproduzivel obj = fig.get(i);
            if (this.verificaObjetoEm(obj, x, y)) {
                return obj;
            }
        }
        return null;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // paintComponent redesenha o painel
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
        int maxX = 0;
        int maxY = 0;
        for (int i = 0; i < fig.size(); i++) {
            Reproduzivel figure = fig.get(i);
            figure.reproduzir(g);
            if (maxX < figure.x()+figure.largura()) {
                maxX = figure.x()+figure.largura();
            }
            if (maxY < figure.y()+figure.altura()) {
                maxY = figure.y()+figure.altura();
            }
        }
        setPreferredSize(new Dimension(maxX+20, maxY+20));
        this.revalidate();
    }
}