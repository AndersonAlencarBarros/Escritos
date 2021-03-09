package OpenClose;

public class Main {

    public static void main(String[] args) {
        DescontoLivroAcao descontoLivroAcao = new DescontoLivroAcao();
        DescontoLivroInfantil descontoLivroInfantil = new DescontoLivroInfantil();

        ControladorDeDesconto c = new ControladorDeDesconto();

        System.out.println(c.adicionarDescontoLivro(descontoLivroAcao));
        System.out.println(c.adicionarDescontoLivro(descontoLivroInfantil));

    }
}
