package Debug;

public class IMC {
    public Double calculaIMC(final Pessoa pessoa) {
        final var altura = pessoa.getAltura();
        final var IMC = pessoa.getPeso() / (altura * altura);

        return IMC;
    }
}
