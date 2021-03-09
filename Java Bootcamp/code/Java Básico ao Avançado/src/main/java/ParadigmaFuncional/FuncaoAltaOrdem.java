package ParadigmaFuncional;

public class FuncaoAltaOrdem {
    public static void main(String[] args) {
        Calculo calculo = (a,b) -> a + b;
        Calculo subtrair = (a,b) -> a - b;
        Calculo dividir = (a,b) -> a / b;
        Calculo multiplicar = (a,b) -> a * b;

        System.out.println(executarOperacao(calculo, 1, 3));
        System.out.println(executarOperacao(subtrair, 1, 3));
        System.out.println(executarOperacao(dividir, 1, 3));
        System.out.println(executarOperacao(multiplicar, 1, 3));
    }

    public static int executarOperacao(Calculo c, int a, int b) {
        return c.calcular(a, b);
    }
}

interface Calculo {
    public int calcular(int a, int b);
}