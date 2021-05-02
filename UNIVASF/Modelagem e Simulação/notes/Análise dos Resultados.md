# Análise dos Resultados

**MML** dilui os transiente dividindo a simulação em lotes

**MRI** aproveita a parte estacionário da simulação. Apenas lotes no estado estacionário

**Amostra** subconjunto da população.

**Desvio padrão** é uma medida fraca. Ele diz respeito a amostra, porém teste estatístico é baseado em população.

**Intervalo de confiança** mais confiável, pois trata da população. 

Importância das variáveis `tsf, U, nf`

Dois lados: **clientes** e **negócio**

**tsf** porque é importante ao cliente, tempo de resposta. Tempo que o cliente pede e volta a ele. 99% do limite superior do intervalo de variância

Do lado do negócio

**U** diz respeito ao servidor, não pode ser sobrecarregado. 90% do limite superior do intervalo de variância

**nf** diz respeito a fila, ao buffer, é a memória e se lotar vai haver perdas. 90% do limite superior do intervalo de variância

Existe um intervalo de confiança, variância e média de `tsf, U e nf` para cada lote.

**Software**

**T do lote** diferença do sps pelo cps (chegada do pacote no sistema)

**U do lote** tempo de serviço E(1) multiplica pela quantidade B (pf - pi) e divide por T

Estatística para cada lote é calculado pelo software zi

a variância e o intervalo de confiança é manual.

**MRI** faz várias simulações, grandes o suficiente e aproveita a parte final de cada uma delas.

**Estatística** é usada quando não existe uma lei que não se aplica.