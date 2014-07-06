package models;

import models.Ponto;

public class Entrada extends Circulo {
    PortaLogica referencia;
    Entrada(PortaLogica referencia, int x, int y) {
        super(x, y, 5);
        this.referencia = referencia;
    }

    public int x0() {
        return this.referencia.x() + super.x0();
    }
    public int y0() {
        return this.referencia.y() + super.y0() ;
    }
}
