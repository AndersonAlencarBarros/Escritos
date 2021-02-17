# Desenvolvimento avançado em Java :coffee:

#### Sumário

- **[Paradigma Funcional no Java](#paradigma-funcional-no-java)**
  - [Conceitos fundamentais da Programação Funcional](#conceitos-fundamentais-da-programacao-funcional)
  - [Expressões Lambda no Java](#expressoes-lambda)
  - [Recursividade em Java](#recursividade-em-java)
- [Interfaces funcionais](#interfaces-funcionais)
- [Processamento Assíncrono e Paralelo]
- [Modularização do Java]
- [Java 10]
- [ Java 11]

## Paradigma Funcional no Java <a name="paradigma-funcional-no-java"></a>

> Programação funcional é o processo de construir software através de composição de funções puras, evitando compartilhamento de estados, dados mutáveis e efeitos colaterias. É declarativa ao invés de imperativa.
>
> Eric Elliott

**Paradigma Imperativo** é aquele que expressa o código através de comandos ao computador, nele é possível ter controle do estados dso objetos.

**Paradigma Funcional** damos uma regra, uma declaração de como queremos que o programa se comporte. 

### Conceitos fundamentais da Programação Funcional <a name="conceitos-fundamentais-da-programacao-funcional"></a>

- **Composição de funções** é criar uma nova função através da composição de outras. Seria como receber uma função como parâmetro ou o uso da `Streams`. Além de melhorar a legibilidade do código.

Por exemplo, dado um ArrayList

```java
import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Integer> valores = new ArrayList<>();
        valores.add(1);
        valores.add(2);
        valores.add(3);
        valores.add(4);
    }
}
```

No Paradigma Funcional, temos

```java
valores.stream()
        .filter(num -> num % 2 == 0)
        .map(num -> num * 2)
        .forEach(System.out::println);
```

Enquanto que no Paradigma Imperativo teriamos

```java
for (int i = 0; i < valores.size(); i++) {
    int v = 0;
    if (valores.get(i) % 2 == 0) {
        v = valores.get(i) * 2;

        if (v != 0)
            System.out.println(v);
    }
}
```

Logo, no Paradigma Funcional temos um código mais limpo, organizado e fácil de depurar.

- **Funções Puras** são chamadas assim pois quando invocadas mais de uma vez produzem exatamente o mesmo resultado.

- **Imutabilidade** uma vez que uma variável que recebeu um valor ou um objeto é criado não é permitido que seja modificado.

### Expressões Lambda no Java <a name="expressoes-lambda"></a>

Os lambdas obedecem o conceito de paradigma funcional e com eles é possível facilitar a legibilidade do código, além de uma alta produtividade para lidar com objetos.

**Interface Funcional** são interfaces que possuem apenas um método abstrato a nível de classe. Com apenas um método, o compilador já consegue interpretar do que se trata.

```java
public class LambdaExample {
    public static void main(String[] args) {
        // Declaração de uma função lambda
        // com uma Interface Funcional
        Funcao funcao = valor -> "Sr. " + valor;
        // Chamada da função lambda
        System.out.println(funcao.gerar("Anderson"));
		
        // Quando a lambda tem mais de uma instrução, é necessário uso de chaves {}.
        // Se o return for diferente de void, é preciso especificar
        Funcao funcao1 = valor -> {
            String prefixo = "Sr. ";
            String nome = prefixo + valor;
            return nome;
        };
		
        System.out.println(funcao1.gerar("Ana"));
    }
}

@FunctionalInterface
interface Funcao {
    String gerar(String s);
}
```

### Recursividade em Java <a name="recursividade-em-java"></a>

Uma função chama a si mesma repetidamente até atingir uma condição de parada. Cada chamada gera uma nova alocação na pilha de execução e alguns dados podem estar em um escopo global ou local. 

Toda recursividade tem dois casos: o **caso base**, que significa o critério de parada e o **caso recursivo**, que chama de novo a função e continua a recursão.

Recursão tem a desvantagem de consumir muita memória e com várias chamadas de recursão, existe uma redução de desempenho.

```java
public static int fat(int v) {
 	// caso base
    if(v == 1) {
        return v;
    } else {
        return v * fat(v - 1); // caso recursivo
    }
}
```

**Tail Recursion ou Tail Call** é uma recursão onde não há nenhuma linha de código após a chamada do próprio método, não há nenhum processamento a ser feito após a chamada recursiva. É lançado um estouro de pilha (StackOverflow) caso a recursão fique muito grande, sendo mais comum em linguagens que tem um paradigma funcional.

```java
// Exemplo de fatorial com Tail Recursion
// O parâmetro result armazena o valor em cada chamada
public static int fatTailCall(int v, int result) {
    if (v == 0)
        return result;

    return fatTailCall(v - 1, result * v);
}
```

**Memoization** é uma técnica de otimização que consiste no cache do resultado de uma função, baseado nos parâmetros de entrada, com isso é possível uma execução mais rápida. Técnica muito usada em Programação Dinâmica.

```java
static Map<Integer, Integer> mapFatorial = new HashMap<>();
public static int fatMemoization(Integer v) {
    if (v == 1)
        return v;
    else {
        if (mapFatorial.containsKey(v))
            return mapFatorial.get(v);
        else {
            Integer resultado = v * fatMemoization(v - 1);
            mapFatorial.put(v, resultado);
            return resultado;
        }
    }
}
```

## Interfaces funcionais <a name="interfaces-funcionais"></a>

