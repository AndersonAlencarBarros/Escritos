# Introdução a Sistemas de Controle

*Anderson de Alencar Barros*

![image-20210302144138931](../attachments/image-20210302144138931.png)

> Sistema é uma entidade que processa um conjunto de sinais, resultando em um outro conjunto de saídas.
>
> Lathi

> Definido como uma entidade que manipula sinais para realizar uma função, produzindo novos sinais.
>
> Haykin

**Sistemas SISO (Single Input Single Output)** possuem uma única entrada e uma única saída.

**Sistemas MIMO (Multiple Input Multiple Output)** possuem mais de uma entrada e mais de uma saída.

## Categorias de Sistemas

- **Sistemas de tempo contínuo** é aquele que os sinais de entrada e de saída são de tempo contínuo

- **Sistemas de tempo discreto** os sinais de entrada e saída são discretos

- **Linearidade** é aquele que

<img src="../attachments/image-20210302145424653.png" alt="image-20210302145424653" style="zoom: 67%;" />

Princípio da superposição é uma propriedade da Linearidade.

- **Invariância no tempo** são sistemas com parâmetros constantes
- **Causalidade** se a saída no instante presente depende de valores passados e presentes da entrada e não de valores futuros. São sistemas físicos ou **não antecipativos**
- **Sistemas Instantâneos** aqueles sem memória, a saída atual depende entrada no mesmo instante
- **Sistemas  Dinâmicos** com memória, a saída atual depende das entrada e/ou saídas passadas, como sistemas que armazenam energia
- **Sistemas de parâmetros concentrados** onde os parâmetros descrevem propriedades que se manifestam em pontos bem definidos do sistema
- **Sistemas de parâmetros distribuídos** onde os parâmetros descrevem propriedades que aparecem apenas em partes do sistema ou em todo o sistema
- **Estabilidade** se, e somente se, toda entrada limitada resultar em uma saída limitada, conhecida como **BIBO (Bounded Input Bounded Output)**

## Sistemas de Controle em Malha Aberta

![image-20210313104544718](../attachments/image-20210313104544718.png)

## Sistemas de Controle em Malha Fechada ou Sistemas com Realimentação

A saída é medida e comparada com um valor de entrada desejado., afim de corrigir eventuais erros.

As saídas são as variáveis controladas

![image-20210313104600849](../attachments/image-20210313104600849.png)

![image-20210313104623500](../attachments/image-20210313104623500.png)

**Zeros** são valores de *s* que fazem G(s) = 0

Ou seja, leva o numerador a zero.

Fazendo o limite, G(s) também pode ir a zero, fazendo com que o infinito também seja um zero

**Polos** fazem G(s) ir para o infinito

Ou seja, leva o denominador a zero