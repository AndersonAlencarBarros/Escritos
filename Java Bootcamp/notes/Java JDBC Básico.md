# Java JDBC Básico

*Anderson de Alencar Barros*

#### Sumário

- **[Introdução](#1)**
- **[JDBC e os drivers de conexão](#2)**
- **[Consultas com JDBC](#3)**

## Introdução <a name="1"></a>

**Banco de dados** armazena dados de forma estruturada, tornando o acesso e atualização dos dados mais rápida, pois aumenta a eficiência computacional.

O **JDBC (Java Database Connectivity)** é uma API com classes e interfaces em Java presente nos pacotes `java.sql` e `javax.sql` para realizar conexões em banco de dados para consultas. O driver JDBC é o intermediário nessa interação.

A API JDBC ajuda a abstrair o banco de dados, não sendo necessário conhece o protocolo proprietário de diversos bancos de dados, sendo o driver o responsável por implementar as especificações de cada banco. 

A classe `DriverManager` é responsável pela comunicação com os drivers disponíveis.

A interface `Connection` representa a conexão com o banco de dados e permite criar **statements** que constroem consultas em SQL.

## JDBC e os drivers de conexão <a name="2"></a>

Para criar uma conexão com o banco de dados, primeiramente, deve-se baixar o driver relativo ao banco, que neste caso foi o PostgreSQL, que foi fácil graças ao Gradle, apenas inserindo a linha 

```java
implementation group: 'org.postgresql', name: 'postgresql', version: '42.2.19'
```

na seção de `dependencies` do Gradle.

Para se conectar com um banco precisamos de um link com o formato

```java
jdbc:<driver>://<endereço do banco>/<nome do banco de dados>
```

Para facilitar a leitura e manutenção podemos fazer

```java
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.SQLException;

String driver = "postgresql";
String dataBaseAddress = "localhost";
String dataBaseName = "dio";
String user = "postgres";
String password = "12345";

String urlConnection = "jdbc:"  + driver
    + "://" + dataBaseAddress
    + "/"   + dataBaseName;
```

Por fim, para iniciar a conexão

```java
// try-catch-resource a partir do Java 7
try (Connection conn = DriverManager.getConnection(urlConnection, user, password)) {
    System.out.println("Banco Conectado com Sucesso");
} catch (Exception e) {
    System.out.println("Banco Não Conectado");
}
```

## Consultas com JDBC <a name="3"></a>

São 3 interfaces para usar comandos SQL:

- `Statement` para SQL comuns, de forma estática;
- `PreparedStatement` para executar SQL parametrizáveis;
- `CallableStatement` para executar *store procedures*.

`PreparedStatement` é recomendado ao parametrizar as consultas por evita alguns problemas, como o ataque de SQL Injection, melhor legibilidade e desempenho.

Existem 3 métodos para executar os comandos em SQL:

- `execute` para qualquer tipo de SQL;
- `executeQuery` para o comando *SELECT*;
- `executeUpdate` para alteração no banco de dados, como *INSERT*, *UPDATE*, *DELETE*, *CREATE*, *ALTER*.

O objeto `ResultSet` contém os dados de uma dada consulta e com getters podemos ter acesso aos dados.