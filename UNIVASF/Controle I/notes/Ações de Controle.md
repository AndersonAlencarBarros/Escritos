# Ações de Controle

**Controlador Proporcional (P)** uma constante é atribuída e o valor é alterado para posicionar os polos nos pontos desejados

**Controlado Proporcional Integral (PI)** podem ser usados para melhorar a resposta do sistema em regime permanente, aumentando a precisão da resposta. Capacita o sistema a rastrear o sinal com erro nulo

A ideia básica é colocar um polo na origem, porém isso altera o LR, então coloca-se um zero bem próximo ao polo na origem. Em malha fechada, isso aumenta o tempo de acomodação.

**Controlador Proporcional Derivativo (PD)** atuam sobre a resposta transitória modificando os polos dominantes

**Controlador Proporcional Integral Derivativo (PID)** 

A ação integral reduz ou anula erros estáticos, porém aumenta a estabilidade relativa e o amortecimento da resposta 

Para reduzir ainda mais o erro estacionário para uma dada entrada, é possível elevar o Kp

A  ação derivativa aumenta o amortecimento os ruídos, porém melhora a estabilidade

Por isso deve-se equilibrar os três termos: proporcional, integral e derivativo

Primeiro, calcula-se o controlador PD para atender as especificações da resposta transitória

Em seguida, projeta o PI para atender às especificações de erro da resposta de regime permanente

