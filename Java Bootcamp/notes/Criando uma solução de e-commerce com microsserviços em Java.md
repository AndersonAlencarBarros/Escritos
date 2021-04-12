# Criando uma solução de e-commerce com microserviços em Java

**Domínio**

<img src="../attachments/image-20210401235247282.png" alt="image-20210401235247282" style="zoom:67%;" />

**Arquitetura**

<img src="../attachments/image-20210401235319154.png" alt="image-20210401235319154" style="zoom:67%;" />

Comunicação entre as partes

![image-20210401235421138](../attachments/image-20210401235421138.png)

**Streaming Data** lidar com grande quantidades de dados em tempo real de várias fontes.

![image-20210401235519261](../attachments/image-20210401235519261.png)

**Apache Kafka** é uma plataforma de mensagens e streaming.

- **Mensagens** é informação produzida por um produtor

- **Tópicos** é o meio onde as mensagens são encaminhadas, onde existem partições e uma ordem de mensagens

- **Produtores** criam mensagens

- **Consumidores** consomem as mensagens

- **Brokers** instâncias do Kafka

- **Cluster** são várias instâncias de brokers

- **Apache Zookeeper** gerencia os clusters

![image-20210406212856452](../attachments/image-20210406212856452.png)

**Apache Avro** sistema de serialização de dados. Fornece uma rica estrutura de dados, formato de dado binário, compacto e rápido e um container para gravar dados persistentes. Similar ao JSON.

**Schema Registry** mecanismo de armazenamento para o Apache Avro.

![image-20210406214804443](../attachments/image-20210406214804443.png)

### Passos

1. Spring Initializer para criar o projeto e adicionar dependências
2. Definir os contratos da API, para que o frontend trabalhe em paralelo com o backend. Definir os dados que serão enviados e recebidos e as funções HTTP.   
3. Definir a estrutura dos pacotes e arquivos: config (config do spring), resource (similar ao controller) e streaming (para o Kafka)
4. Criar a classe entity, repository, service, 