# Diagrama do Lugar as Raízes

O método do lugar das raízes permite localizar no plano *s* as raízes da equação característica de um sistema de malha fechada, em função da variação de um parâmetro (geralmente o ganho K), a partir da função de transferência de malha aberta

Permite visualizar as possibilidades e limitações do comportamento de malha fechada de um sistema a partir do conhecimento de polos e zeros da malha aberta

Os **polos de macha fechada (da função de transferência)** no plano *s* faz uma trajetória que inicia nos **polos de malha aberta** e se dirigem para os **zeros de malha aberta**, ou na falta destes, vão para infinito.

Os polos de **malha fechada (MF)** tentem para os zeros de **malha aberta (MA)**.

A trajetória é chamada de **ramos** do lugar das raízes.

**Condição de ângulo**  |A(s)| = 1 

O ângulo deve ser múltiplo de 180

Projetar um controlador significa determinar Gc(s) que altere Gp(s) para que atenda as especificações

- Tempo de estabelecimento pelo critério de 2% (te)
- Sobressinal (Mp) 
- Tempo de subida (ts)
- Tempo de pico 
- Erro em estado estacionário

### Regras

1. Localizar os polos e zeros de malha aberta no plano s. 
2. Determinar o número total de ramos do LR, este é igual ao número de polos de malha aberta (*m.a*) e é indicado um percurso quando K cresce
3. Determinar os segmentos do LR pertencentes ao eixo real, estes se situam à esquerda de um número ímpar de polos + zeros, pois satisfazem a condição angular 
4. Determinar os ramos que vão para o infinito, subtraindo *p - z*, onde *p* é o número de polos de *m.a* e *z* os zeros de *m.a* de A(s)
5. Determinar os pontos de separação sobre o eixo real, onde há conflito de percurso, que ao se encontrarem, deixam o eixo real e tornam-se polos complexos no plano s. Também é onde K é máximo
6. Comportamento no infinito: todas as assíntotas que vão para o infinito saem do mesmo ponto no eixo real. Calcular o angulo entre as assíntotas e posição de irradiação das assíntotas

Todo diagrama LR é simétrico em relação ao eixo real

