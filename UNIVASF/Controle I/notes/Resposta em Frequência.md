# Resposta em Frequência

Resposta em regime permanente de um sistema a uma entrada senoidal.

A saída tem a forma $y = Ysen(\omega t + \theta_y)$

- Representação 
  - Diagrama de Bode ou Gráfico Logarítmico
  - Diagrama de Nyquist ou Diagrama Polar
  - Diagrama Logarítmico do módulo vesus ângulo de fase

O mais usado é o Diagrama Polar por ser possível visualizar toda a faixa de frequência. Para se ter uma ideia do gráfico calcula-se o limite da função de trasnferência G(s) quando $\omega$ tende a zero e ao infinito

**Critério de Estabilidade de Nyquist** determina a estabilidade do sistema de malha fechada com  base na resposta em frequência de malha aberta A(j$\omega$) ao número de zeros e polos de 1 + A(s) no SPD de s. 

**Teorema do Mapeamento** **e a Análise de Estabilidade**

Envolve o SPD com o contorno no plano s (Percurso de Nyquist). Se no SPD não houver zeros de F(s) = 1 + A(s), também não tem polos de malha fechada e o sistema é estável.

Envolvimento do ponto -1 + j0 pelo lugar geométrico de A(j$\omega$) quando $\omega$ tente de $-\infty$ a $+\infty$ P vezes, sendo P o número de polos de A(s) no SPD de s.

Para ser estável não deve exister envolvimentos desse ponto, Z = N

**Para verificar se é estável**, verifica se o Diagrama Polar de A(j$\omega$) envolve -1 + j0.

A proximidade com um ponto crítico indica a **estabilidade relativa**

A distância à origem onde o gráfico corta o eixo real negativo é o módulo de A(j$\omega$)

**Margem de ganho** é o inverso do módulo de A(j$\omega$). Se a margem de ganho (em dB) for positiva, o sistema é estável. Não indica a estabilidade absoluta do sistema.

**Margem de fase** ângulo $\beta$ entre o eixo real negativo e o vetor A(j$\omega$) onde o módulo do vetor é unitário. Se $\beta$ é positivo o sistema é estável.

### Controlador por Avanço de Fase

$$
G_c(s) = \frac{K_c (s + \alpha a)}{s + a}
$$

onde $\alpha$ é o *fator de atenuação do compensador por avanço de fase* e $0 < \alpha < 1$

$\phi_m$ margem de fase máxima em uma dada frequência. Vem das especificações do projeto.

$$
\alpha = \frac{1 - sen\phi_m}{1 + sen\phi_m}
$$


$$
\omega_m = \textrm{a}\sqrt\alpha
$$
