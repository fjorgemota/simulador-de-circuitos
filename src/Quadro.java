import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Quadro extends JPanel {
    private java.util.List<Reproduzivel> fig = new ArrayList<Reproduzivel>();
    int raio = 20, k = 0; // ponto central

    void addFig(Reproduzivel fig){
        this.fig.add(fig);
        k+=1;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); // paintComponent redesenha o painel
        for (int i = 0; i < fig.size(); i++) {
            fig.get(i).reproduzir(g);
        }
    }
}