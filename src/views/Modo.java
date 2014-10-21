package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Modo implements ActionListener {
    public static String
            EDITAR = "EDITAR",
            CRIAR = "CRIAR",
            APAGAR = "APAGAR",
            SIMULAR = "SIMULAR";

    public String modoAtual = CRIAR;

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals(EDITAR)) {
            modoAtual = EDITAR;
        } else if (comando.equals(CRIAR)) {
            modoAtual = CRIAR;
        } else if (comando.equals(APAGAR)) {
            modoAtual = APAGAR;
        } else if (comando.equals(SIMULAR)) {
            modoAtual = SIMULAR;
        }
    }

    public boolean estaEditando() {
        return modoAtual.equals(EDITAR);
    }

    public boolean estaApagando() {
        return modoAtual.equals(APAGAR);
    }

    public boolean estaCriando() {
        return modoAtual.equals(CRIAR);
    }
    public boolean estaSimulando() {
        return modoAtual.equals(SIMULAR);
    }
}
