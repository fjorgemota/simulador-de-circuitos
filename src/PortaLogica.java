public abstract class PortaLogica extends Retangulo{
    protected PortaLogica(Ponto ponto1, Ponto ponto2) {
        super(ponto1, ponto2);
    }

    public abstract Entrada[] pegaEntradas();
    public abstract Saida[] pegaSaidas();
}
