# Implementando Collections e Streams com Java

<img src="../attachments/1200px-Java.util.Collection_hierarchy.svg.png" style="zoom:67%;" />

#### Sumário

- **[List](#list)**
  - [ArrayList](#arraylist)
  - [Vector](#vector)
- **[Queue](#queue)**
- **[Set](#set)**
  - [HashSet](#hashset)
  - [LinkedHashSet](#linkedhashset)
  - [TreeSet](#treeset)
- **[Map](#map)**
  - [HashMap](#hashmap)
  - [TreeMap](#treemap)
  - [HashTable](#hashtable)
- **[Comparators](#comparators)**
- **[Utilizando o Optional](#utilizando-o-optional)**
- **[Comparators](#comparators)**
- **[Streams - Dominando fluxo de dados](#streams)**

## List <a name="list"></a>

Na `java.util.List` existe as implementações *ArrayList* e *Vector*  

- Ambos são implementados encima do array 
- Garante uma ordem de inserção
- Permite adição, atualização, leitura e remoção
- Permite ordenação por meio de *comparators*

### ArrayList <a name="arraylist"></a>

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // Declaração de um ArrayList
    	List<String> nomes = new ArrayList<>();
    }
}
```

- `nomes.add("Anderson")` adiciona elementos
- `Collections.sort(nomes)` ordena a lista, requer `import java.util.Collections;`
- `nomes.set(0, "Maria")` altera o elemento de uma posição 
- `nomes.remove(2)` remove um elemento de uma dada posição
- `nomes.remove("Anderson")` também é possível remover passando o elemento como parâmetro 
- `nomes.get(2)` retorna o elemento da posição indexada, pode ocorrer de acessar uma posição inválida da memória
- `nomes.size()` retorna o tamanho
- `nomes.contains("Anderson")` verifica se está na lista
- `nomes.indexOf("Joana")` retorna a posição de um elemento, retorna -1 se não estiver na lista
- `nomes.isEmpty()` verifica se está vazia
- `nomes.clear()` limpa a lista

**Vale deixar claro que uma séria de métodos estão implementados na interface `Collections` por isso são comuns a todas as estruturas, como `size()`,`isEmpty()`, `clear()` e etc.**

Para iterar sobre a lista pode-se fazer

```java
for(String nome : nomes)
    System.out.printf(" %s :", nome);

// import java.util.Iterator; 
Iterator<String> it = nomes.iterator();
while (it.hasNext())
    System.out.println("-> " + it.next());
```

### Vector <a name="vector"></a>

Tanto ArrayList quando Vector tem os mesmo métodos

```java
import java.util.Vector;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VectorExample {
    public static void main(String[] args) {
        List<String> nomes = new Vector<>();		
    }
}
```

Desse modo, a diferença entre ArrayList e Vector são que

- Vector são sincronizados por padrão, e ArrayList não.

Pode-se tornar ArrayList também sincronizado passando o objeto ArrayList para o método `Collections.synchronizedList()`  
Sincronizado significa que pode ser usado com vários threads sem qualquer efeito colateral. 

- As ArrayLists aumentam em 50% do tamanho quando o espaço não é suficiente para o novo elemento, enquanto o Vector aumentará 100% do tamanho quando não houver espaço para o novo elemento de entrada.

Por ArrayList não ser sincronizado significa mais velocidade, por isso é sempre recomendado usar ArrayLists se não houver um requisito específico para usar Vector

## Queue <a name="queue"></a>

Na `java.util.LinkedList`  é onde está implementada a queue (fila)

- Garante uma ordem de inserção
- Segue a regra **FIFO**, o primeiro que entra é o primeiro que sai

```java
import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        Queue<String> fila = new LinkedList<>();
    }
}
```

- `fila.add("João")` adiciona elementos na fila
- `fila.poll()` retorna e remove primeiro elemento
- `fila.peek()` lê o primeiro da fila, caso a fila esteja vazia, ele retorna `null`
- `fila.element()` retorna o primeiro elemento, porém se a fila estiver vazia, ocorre um erro de execução  `NoSuchElementException`
- `fila.isEmpty()` verifica se está vazia
- `fila.clear()`  limpa a fila

Para iterar sobre a fila pode-se fazer como na lista

```java
for (var s : fila)
    System.out.println(s);

var it = fila.iterator();
while (it.hasNext())
    System.out.println("-> " + it.next());
```

## Set <a name="set"></a>

Implementações do `java.util.Set` são `java.util.HashSet`, `java.util.TreeSet` e `java.util.LinkedHashSet`

- Não garantem ordem de inserção
- Não permite itens repeditos
- Permite adição e remoção normalmente 
- Não possuem busca por item e atualização 
- Não é indexada, mas é possível iteração 
- Não permite mudança de ordenação, permitido apensar por o `java.util.TreeSet` e `java.util.LinkedHashSet`

A `java.util.Set` foi criada para ser performática, para ser trabalhada com grandes conjuntos de dados, por isso não mantém a ordem, para conseguir um ganho de desempenho. A `java.util.LinkedHashSet` permite ordenação, porém se perde o desempenho

![image-20210215144438163](../attachments/image-20210215144438163.png)

### HashSet <a name="hashset"></a>

O Set e o HashSet não garantem a ordem de inserção justamente para obter maior performance na adição, remoção e leitura de dados, por exemplo, quando se trabalha com grandes quantidades de dados vindo de um banco de dados

```java
import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        // Declaração
        Set<Double> notasAlunos = new HashSet<>();

        // adiciona elementos
        notasAlunos.add(3.4);
        notasAlunos.add(10.0);
        notasAlunos.add(5.2);
        notasAlunos.add(1.1);
        notasAlunos.add(7.4);
  	
        // remove passando um objeto como parâmetro
        notasAlunos.remove(1.1);
	
        // iterar sobre o Set
        var it = notasAlunos.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        for (var d : notasAlunos)
            System.out.println("-> " + d);
		
        // limpa o Set
        notasAlunos.clear();

        // verifica se está vazio
        notasAlunos.isEmpty();
    }
}
```

### LinkedHashSet <a name="linkedhashset"></a>

- Permanece a ordem natural de inserção, o que faz ser um pouco mais lenta que o HashSet 
- De resto, mantém os mesmos métodos

```java
import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // Declaração
        LinkedHashSet<Integer> seq = new LinkedHashSet();
    }
}
```

### TreeSet <a name="treeset"></a>

É baseado em árvores binárias, desse modo, os métodos são equivalentes ao de manipulação de árvores. Toda vez que é modificado a estrutura do TreeSet o algoritmo de ordenação é executado novamente

```java
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        // Declaração
        TreeSet<String> treeSet = new TreeSet<>();
    }
}
```

- `treeSet.add("Anderson")` adiciona elementos
- `treeSet.first()` retorna o primeiro elemento da árvore
- `treeSet.last()` retorna o último elemento da árvore
- `treeSet.lower("Anderson")`  retorna o maior elemento neste conjunto que é estritamente menor do que o elemento fornecido.
- `treeSet.higher("Anderson")` retorna o menor elemento neste conjunto que é estritamente maior do que o elemento fornecido.
- `treeSet.pollFirst()` retorna e remove o primeiro da árvore
- `treeSet.pollLast()` retorna e remove o último da árvore

## Map <a name="map"></a>

Implementações do `java.util.Map` são `java.util.HashMap`, `java.util.TreeMap` e `java.util.HashTable`

- Entrada de chave e valor 
- Permite valores repetidos, porém com chaves diferentes 
- Permite adição, busca por chave ou valor, atualização, remoção e navegação 
- Pode ser ordenado

![Java Map Hierarchy](../attachments/java-map-hierarchy.png)

### HashMap <a name="hashmap"></a>

Não é sincronizado, é o mais rápido entre todos e mais recomendado na maioria das situações e permite adicionar valores `null`

```java
import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // Declaração
        Map<String, Integer> campeoes = new HashMap<>();
        
        campeoes.put("Brasil", 5);
        campeoes.put("Alemanha", 4);
        campeoes.put("Itália", 4);
        campeoes.put("Argentina", 2);
    }
}

```

- `campeoes.put("Brasil", 5)`  adiciona ou atualiza valores
- `campeoes.get("Alemanha")` 
- `campeoes.containsKey("Canadá")`
- `campeoes.remove("Itália")`
- `campeoes.containsValue("2")`
- `campeoes.size()`

Para iterar sobre o `HashMap` pode-se fazer

```java
for (String s : campeoes.keySet())
    System.out.println(s + " - " + campeoes.get(s));
```

### TreeMap <a name="treemap"></a>

Também não sincronizado, porém a cada modificação o algoritmo da árvore é executado novamente.

```java
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        // Declaração
        TreeMap<String, String> capitais = new TreeMap<>();

        capitais.put("RS", "Porto Alegre");
        capitais.put("PE", "Recife");
        capitais.put("CE", "Fortaleza");
        capitais.put("MG", "Belo Horizonte");
        capitais.put("SC", "Floripa");
        capitais.put("AC", "Rio Branco");

    }
}
```

- `capitais.put("RS", "Porto Alegre")` adiciona ou atualiza elementos
- `capitais.firstKey()` retorna o primeiro par da árvore
- `capitais.lastKey()` retorna o último par da árvore
- `capitais.lowerKey("AC")` mostra quem está abaixo de um elemento
- `capitais.higherKey("PE")` mostra quem está acima de um elemento
- `capitais.firstEntry()` retorna o par com o valor da chave mais baixo entre todos
- `capitais.lastEntry()` retorna o par com o valor da chave mais alta
- `capitais.pollFirstEntry()` retorna e remove o primeiro da árvore
- `capitais.pollLastEntry()` retorna e remove o último da árvore
- `capitais.higherEntry("PE")` retorna o menor elemento neste conjunto que a chave é maior que a chave do que o elemento fornecido
- `capitais.lowerEntry("CE")` retorna o maior elemento neste conjunto que a chave é menor que a chave do que o elemento fornecido

Para iterar no `TreeMap` pode-se fazer

```java
var it = capitais.keySet().iterator();
while (it.hasNext())
    System.out.println(it.next() + " - " + capitais.get(it.next()));
```

### HashTable <a name="hashtable"></a>

É sincronizado, por isso, é mais lento que o `HashMap` e mais antigo. Não é recomendado usar há não ser em situações específicas.  
Possui os mesmo métodos que `HashMap`

```java
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        // Declaração
        Map<String, Integer> hashtable = new Hashtable<>();
    }
}
```








