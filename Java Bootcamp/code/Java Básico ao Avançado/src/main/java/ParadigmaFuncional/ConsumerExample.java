package ParadigmaFuncional;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

//         O método accept() vem da interface Consumer
//         é preciso usar o recurso da interface para
//         implementar um comportamento
//         Consumer não tem retorno, apenas recebe um parâmetro
//         e faz algo com esse parâmetro
        Consumer<String> print = frase -> System.out.println(frase);
        print.accept("Oi, eaw");

        // Method Reference
        Consumer<String> printString = System.out::println;
        printString.accept("Oi, tudo ok");
    }
}
