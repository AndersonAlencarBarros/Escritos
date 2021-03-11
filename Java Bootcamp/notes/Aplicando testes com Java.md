# Aplicando testes com Java

#### Sumário

- **[Testes Unitários com JUnit](#testes-unitarios-com-junit)**
  - [Asserts](#asserts)
  - [Rules](#rules)
  - [Testando Exceções](#testando-exceções)
- **[Explorando Mocks e Asserts](#mocks-e-asserts)**
-   **[Test Driven Development (TDD)](#tdd)**

## Testes Unitários com JUnit <a name="testes-unitarios-com-junit"></a>

[JUnit](https://junit.org/junit4/) é um framework simples e de código aberto para escrever testes repetidamente. JUnit é ideal para testes unitário, aqueles que testam apenas uma funcionalidade da aplicação. 

A cada *build* os testes são realizados e apenas é realizado quando a aplicação passa em todos os testes.

### Asserts <a name="asserts"></a>

Asserts são usados para validar os testes e se os resultados coincidem com os esperados. Existem *assertions* para tipos primitivos, Object e arrays.

Todo parâmetros dos asserts tem um valor esperado e o valor retornado, como também o primeiro parâmetro é opcional que pode ser uma string em caso de falha no teste, com uma pequena diferença no `assertThat`. 

[Assertions](https://github.com/junit-team/junit4/wiki/Assertions)

### Rules <a name="rules"></a>

Rules altera o comportamento de de cada método de teste, podendo ser realizado algo antes ou depois da execução do método.

Com Rules, podemos criar arquivos ou diretórios; configurar um recurso externo, como banco de dados; liberar o recurso ao final do teste  e etc.

Existem várias Rules para várias situações, como mostra a documentação.

[Rules](https://github.com/junit-team/junit4/wiki/Rules)

### Testando Exceções <a name="testando-exceções"></a>

Existem várias formas de testar exceções. O importante é saber que o código se comporta como esperado quando uma exceção é lançada.

No JUnit 5 foi inserido o `assertThrows` e removido a anotação `@Test` que testa as exceções.

[Exception testing](https://github.com/junit-team/junit4/wiki/Exception-testing)

## Explorando Mocks e Asserts <a name="mocks-e-asserts"></a>

Mocks são objetos simulados, feitos para replicar e testar parte do comportamento de objetos reais. Desse modo, mocks são úteis para simular o comportamento de um objetos complexos, ou lentos (como banco de dados) e entre outros.

[Mokito](http://www.vidageek.net/2013/08/27/mockito-mocks/)

## Test Driven Development (TDD) <a name="tdd"></a>

Test Driven Development (TDD) ou Desenvolvimento Orientado por Testes orienta o desenvolvimento de software primeiro escrevendo os testes antes do código de produção.

1. Escreva um teste
2. Falhe no teste
3. Codifique para passar no teste
4. Refatore
5. Repita o processo

Isso colabora para escrever um código mais limpo, mais seguro já que estamos escrevendo o código que passa no teste, além de outros benefícios.