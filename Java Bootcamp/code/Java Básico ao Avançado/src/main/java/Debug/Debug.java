package Debug;

public class Debug {
    public static void main(String[] args) {
        final Pessoa pessoa = new Pessoa("Anderson", 1.77, 70.0);
        final Pessoa pessoa1 = new Pessoa("Anderson", 1.77, 70.0);

        System.out.println(pessoa.hashCode());
        System.out.println(pessoa1.hashCode());

        final var calculadoraIMC = new IMC();
        final var imc = calculadoraIMC.calculaIMC(pessoa);

        System.out.println("IMC");
        System.out.println(imc);
    }
}















//    Debug é testar o código
//    Breakpoints são pontos onde a execução vai parar para testar,
//    são os círculos vermelhos ao clicar no lado de uma linha de código
//    É necessário clicar em "Debug" para começar, não em "Run"
//    O "Resume Program" segue o programa até o próximo breakpoint
//    "Step Over" executa linha a linha
//    "Step Into" leva até a linha do método que está sendo executado
//    Evaluate Expression pode calcular o valor de uma variável ou expressão
