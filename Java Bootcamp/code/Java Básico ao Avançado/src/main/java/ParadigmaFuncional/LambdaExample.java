package ParadigmaFuncional;

public class LambdaExample {
    public static void main(String[] args) {
        // Quando a lambda tem mais de uma instrução, é necessário uso de chaves {}
        // se o return for diferente de void, é preciso especificar
        Funcao funcao = valor -> "Sr. " + valor;
        System.out.println(funcao.gerar("Anderson"));

        Funcao funcao1 = valor -> {
            String prefixo = "Sr. ";
            String nome = prefixo + valor;
            return nome;
        };

        System.out.println(funcao1.gerar("Ana"));
    }
}

// Interfaces funcionais são interfaces que possuem apenas um método abstrato
// a nível de classe
// Só com um método, o compilador já consegue interpretar do que se trata
// FunctionalInterface é uma proteção (opcional) do Java
// para forçar o compilador a apontar um erro
// se a interface não estiver de acordo com as regras
// de uma interface funcional

@FunctionalInterface
interface Funcao {
    String gerar(String s);
}
