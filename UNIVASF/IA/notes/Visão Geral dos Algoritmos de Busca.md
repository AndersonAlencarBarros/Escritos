# Visão Geral dos Algoritmos de Busca

- **Busca sem Informação ou Busca Cega**
  - Busca em Largura
  - Busca em Profundidade
- **Busca com Informação e Exploração** busca pelo melhor caminho. Os nós são ordenados por uma função de avaliação f(n)
  - **Busca Gulosa** expande o nó que parece mais próximo ao objetivo
  - **Busca A*** usa uma função heurística para encontrar o melhor caminho
- **Algoritmos de Busca Local** usados para otimização onde o caminho é irrelevante e o estado objetivo é a solução
  - **Hill Climb (Subida da Encosta)** mais simples e usado, por exemplo, para buscas de mínimo e máximo
  - **Simulated Annealing** mais sofisticado que a Subida da Encosta e não fica "preso" em um máximo/mínimo local como o anterior, apesar de aumentar o tempo de busca

- **Algoritmo Genético** cria diversas soluções aleatoriamente, das quais são selecionadas as melhores e mais soluções são geradas a partir das selecionadas até que se encontre uma solução ideal
  - **Cromossomo ou Genótipo** estrutura de dados que representa o indivíduo
  - **Aptidão** função objetivo, avalia a solução
  - **Seleção** determina quem participa da reprodução por meio de probabilidade de índices ou aptidão
    - Proporcional ou roleta
    - Torneio
  - **Reprodução** indivíduos são combinados para gerar a próxima geração
    - **Cruzamento (crossover)** pode ser um ponto, multipontos ou uniforme
    - **Mutação** inversão de bits com uma dada probabilidade
    - **Elitismo** o crossover ou mutação podem destruir a melhor solução, transfere uma cópia dos melhores em todas as gerações

- **Busca Competitiva** busca de soma (um perde e outro ganha) zero envolvendo mais de um agente. Enquanto um jogador tenta maximizar, o outro tenta minimizar. 

