---
tags: [Teoria da Computação]
title: Decidibilidade
created: '2020-12-16T17:20:59.327Z'
modified: '2020-12-18T00:51:49.675Z'
---

# Decidibilidade

### Conceito

- Demonstrar se existe ou não um algoritmo que resolve um certo problema;
- Decidibilidade é o estudo dos problemas codificados como linguagens;
- Máquina de Turing (MT) como representação formal de algoritmo
- Dado um problema, existe uma Máquina de Turing que resolve este problema;

### Problema de Decisão

- Problema de decisão: resposta **sim** ou **não**;
- A Máquina de Turing (MT) deve aceitar as cadeias afirmativas do problema e rejeita todas as instâncias onde são negativas;
- Basicamente, saber se a linguagem do problema é recursiva, pois toda linguagem recuriva tem pelo menos uma máquina que aceita todas as instâncias afirmativas e rejeitas as negativas. Dada uma instância qualquer do problema, basta ver se para e aceita ou rejeita, ou seja, se a resposta é sim ou não;
- Se a linguagem for recursivamente enumerável, pode existir uma máquina que para e aceita, porém em uma instância negativa ela pode parar e rejeitar ou, no pior caso, entrar em loop infinito (semidecidível);
- Problema é indecidível se não puder ser representado em uma das duas linguagens.

#### Definições

**Problema solucionável:** linguagem recursiva
**Problema não-solucionável:** linguagem não recursiva

**Problema parcialmente solucionável:** linguagem recursivamente enumerável
**Problema totalmente insolúvel:** linguagem não recursivamente enumerável

### Método diagonal de Cantor

- Mostra como obter um conjunto diferente de todos os conjuntos de uma dada coleção de conjuntos.

- Serve para mostrar se um conjunto é enumerável.

- E é usada para provar que $L_d$ não é recursivamente enumerável

### Linguagem $L_d$: linguagem diagonal

$$
  L_d = \{\omega_1 \in \{0,1\}^* \; | \; \omega_1 \not\in L(M)\}
$$

- É uma linguagem não recursivamente enumerável, formada de 0 e 1 tais as cadeias não são aceitas pela máquina $M_i$. 

- Linguagem que não é aceita por qualquer MT.

- Por isso não é recursivamente enumerável, pois não é aceita por nenhuma Máquina de Turing.

#### Teoremas

- Se L é recursiva, o complemento também é recursiva. De outra forma, se um problema é decidível o complemento também será.

- Se L e seu complemento são recursivament enumeráveis se e somente se L é recursiva

### Máquina de Turing Universal




























