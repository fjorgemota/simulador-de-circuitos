package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modo implements ActionListener {
    public static String
            EDITAR = "EDITAR",
            CRIAR = "CRIAR";

    public String modoAtual = EDITAR;

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals(EDITAR)) {
            modoAtual = EDITAR;
        } else if (comando.equals(CRIAR)) {
            modoAtual = CRIAR;
        }
    }

    public void setaCriando() {
        this.modoAtual = CRIAR;
    }
    public void setaEditando() {
        this.modoAtual = EDITAR;
    }

    public boolean estaEditando() {
        return modoAtual.equals(EDITAR);
    }

    public boolean estaCriando() {
        return modoAtual.equals(CRIAR);
    }
}
