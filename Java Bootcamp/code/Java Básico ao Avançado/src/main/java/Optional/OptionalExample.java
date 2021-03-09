package Optional;

import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public class OptionalExample {
    public static void main(String[] args) {
        // cria um optional, porém este não permite `null`
        // caso seja `null`, um `NullPointerException` é lançado
        Optional<String> opt = Optional.of("Valor Presente");

        // Executa o primeiro parâmetro se o objeto não for nulo
        // executa o segundo caso seja nulo ou vazio
        opt.ifPresentOrElse(System.out::println, () -> System.out.println("Valor nulo"));

        // cria um optional, este método permite o valor `null`
        // caso seja `null`, cria-se um optional vazio
        Optional<String> optNull = Optional.ofNullable(null);
        optNull.ifPresentOrElse(System.out::println, () -> System.out.println("Valor nulo"));

        Optional<String> optEmpty = Optional.empty();
        optEmpty.ifPresentOrElse(System.out::println, () -> System.out.println("Valor nulo"));

        // Existem extensões do Optional para alguns tipos primitivos
        OptionalInt.of(10).ifPresent(System.out::println);
        OptionalDouble.of(10.0).ifPresent(System.out::println);
        OptionalLong.of(23L).ifPresent(System.out::println);

        // Métodos

        // verifica se está presente
        var b = opt.isPresent();
        System.out.println(b);

        // verifica se está vazio
        var c = optNull.isEmpty();
        System.out.println(c);

        // recebe yma expressão lambda se presente
        opt.ifPresent(System.out::println);

        if (opt.isPresent()) {
            // retorna o valor do optional
            var s = opt.get();
            System.out.println(s);
        }

        // se o valor estiver presenta retorna um Optional com o resultado
        // da função de mapeamento de valor, o lambda, caso contrário
        // retorna vazio
        opt.map((v) -> v.concat("***")).ifPresent(System.out::println);

        // se não estiver presente lança uma exceção
        opt.orElseThrow(IllegalAccessError::new);
    }
}
