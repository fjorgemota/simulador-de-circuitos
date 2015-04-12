package views;

import java.io.Serializable;

public interface Selecionavel  extends Serializable {
    public boolean contemPonto(int x, int y);

    public void selecionaPonto(int x, int y);

    public int getXSel();

    public int getYSel();

}
