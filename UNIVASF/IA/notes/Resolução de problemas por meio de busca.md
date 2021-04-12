# Resolução de problemas por meio de busca

Um agente com várias opções pode decidir o que fazer comparando diversas sequências de ações possíveis.

O processo de procurar pela melhor sequência é chamado de **busca**.

Um **problema** é definido por 4 itens:

- Estado Inicial
- Ações ou função sucessora
- Teste de objetivo
- Custo do caminho (ações executadas, distância, entre outros)

**Espaço de estados** todos os estados acessíveis a partir do estado inicial acessados pela função sucessora. Uma abstração do mundo real.

**Borda** coleção de nós gerados, porém não acessados.

**Estratégia de busca** escolha da ordem da expansão dos nós. São critérios de avaliação das estratégias de busca

- Completeza (encontra a solução)
- Otimização
- Complexidade no tempo
- Complexidade no espaço