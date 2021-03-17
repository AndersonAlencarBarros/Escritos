# Java JDBC Básico

*Anderson de Alencar Barros*

#### Sumário

- **[Introdução ao JDBC](#1)**
  - [JDBC e os drivers de conexão](#1.1)
  - [Consultas com JDBC](#1.2)
- **[Trabalhando com JPA](#2)**

## Introdução ao JDBC <a name="1"></a>

**Banco de dados** armazena dados de forma estruturada, tornando o acesso e atualização dos dados mais rápida, pois aumenta a eficiência computacional.

O **JDBC (Java Database Connectivity)** é uma API com classes e interfaces em Java presente nos pacotes `java.sql` e `javax.sql` para realizar conexões em banco de dados para consultas. O driver JDBC é o intermediário nessa interação.

A API JDBC ajuda a abstrair o banco de dados, não sendo necessário conhece o protocolo proprietário de diversos bancos de dados, sendo o driver o responsável por implementar as especificações de cada banco. 

A classe `DriverManager` é responsável pela comunicação com os drivers disponíveis.

A interface `Connection` representa a conexão com o banco de dados e permite criar **statements** que constroem consultas em SQL.

### JDBC e os drivers de conexão <a name="1.1"></a>

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

Também é possível usar um arquivo `connection.properties` dentro da pasta `resources` para facilitar a configuração.

![image-20210316212831777](../attachments/image-20210316212831777.png)

```java
# connections.properties
jdbc.driver=postgresql
db.address=localhost
db.name=dio
db.user.login=postgres
db.user.password=12345
```

O código abaixo mostra a classe `ConnectionFactory` e como ler o arquivo de  propriedades. Esta classe também será usada posteriormente abaixo.

```java
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

    public static Connection getConnection() {
        Connection connection = null;
        // Carregando o arquivo connection.properties
        try(InputStream input = ConnectionFactory.class.getClassLoader()
                                .getResourceAsStream("connection.properties")){

            // Definir parâmetros para se conectar ao banco de dados
            Properties prop = new Properties();
            prop.load(input);

            String driver = prop.getProperty("jdbc.driver");
            String dataBaseAddress = prop.getProperty("db.address");
            String dataBaseName = prop.getProperty("db.name");
            String user = prop.getProperty("db.user.login");
            String password = prop.getProperty("db.user.password");

            // Construção da string de conexão.
            String connectionUrl = "jdbc:"  + driver
                    + "://" + dataBaseAddress
                    + "/"   + dataBaseName;

            // Criar conexão usando o DriverManager,
            // passando como parâmetros a string de conexão, usuário e senha do usuário.
            try {
                connection = DriverManager.getConnection(connectionUrl, user, password);
            } catch (SQLException e) {
                System.out.println("FALHA ao tentar criar conexão");
                throw new RuntimeException(e);
            }

        } catch(IOException e) {
            System.out.println("FALHA ao tentar carregar aquivos de propriedades");
            e.printStackTrace();
        }

        return connection;
    }
}
```

### Consultas com JDBC <a name="1.2"></a>

São 3 interfaces para usar comandos SQL:

- `Statement` para SQL comuns, de forma estática;
- `PreparedStatement` para executar SQL parametrizáveis;
- `CallableStatement` para executar *store procedures*.

`PreparedStatement` é recomendado ao parametrizar as consultas por evita alguns problemas, como o ataque de SQL Injection, melhor legibilidade e desempenho.

Existem 3 métodos para executar os comandos em SQL:

- `execute` para qualquer tipo de SQL;
- `executeQuery` para o comando *SELECT*;
- `executeUpdate` para alteração no banco de dados, como *INSERT*, *UPDATE*, *DELETE*, *CREATE*, *ALTER*.

O objeto `ResultSet` contém os dados de uma dada consulta e com getters podemos ter acesso aos dados. `next()` é usado para iterar sobre o `ResultSet`.

É recomendado ter duas classes para fazer consultas no banco de dados: uma **classe espelho**, com os mesmo atributos da tabela do banco de dados e um **classe DAO,**  Data Access Object, para separar as regras de négocio das regras de acesso ao banco de dados.

Vamos supor uma tabela de alunos, teremos duas classes `Aluno` e `AlunoDAO` e que cada aluno tenha atributos *id*, *nome*, *idade* e *estado*. Então a classe `Aluno` 

```java
public class Aluno {
    // Um espelho do banco de dados
    // Classe para criar objetos recebidos do banco

    private int id;
    private String nome;
    private int idade;
    private String estado;

    public Aluno(int id, String nome, int idade, String estado) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }

    public Aluno(String nome, int idade, String estado) {
        this.nome = nome;
        this.idade = idade;
        this.estado = estado;
    }
    
    public Aluno() {
    }
    
    // Além de métodos getters e setters...
```

Na classe `AlunoDAO` vamos usar a classe `ConnectionFactory` para criar conexões com o banco de dados e implementar por meio de método as regras que desejamos de acesso a ele. Vejamos exemplos

```java
// retorna uma lista de todos os alunos no banco
public List<Aluno> getAlunosList() {
    List<Aluno> alunos = new ArrayList<>();
	
    // Classe ConnectionFactory sendo usada 
    // para criar uma conexão do banco na variável 'conn'
    try(var conn = ConnectionFactory.getConnection()) {
        // Comando SQL em PreparedStatement
        PreparedStatement psrt = conn.prepareStatement("SELECT * FROM aluno");
        // Comando sendo executado pelo armazenado
        ResultSet rs = psrt.executeQuery();
	
        // Com o next() podemos iterar sobre todos os resultados 
        // e com getters recebemos cada dado na tabela 
        // que é usado para instânciar objetos
        while (rs.next()) {
            Aluno aluno = new Aluno(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getInt("idade"),
                rs.getString("estado")
            );

            alunos.add(aluno);
        }

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }

    return alunos;
}
```

Na `Main`, teríamos

```java
AlunoDAO alunoDAO = new AlunoDAO();
List<Aluno> alunos = alunoDAO.getAlunosList();
// imprime todos da lista
alunos.stream().forEach(System.out::println);
```

```java
// retornar os dados de um aluno pelo id
public Aluno getAlunosByID(int id) {
    Aluno aluno = new Aluno();
    try(var conn = ConnectionFactory.getConnection()) {
        // Perceba como o ? é usado para passar um parâmetro
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM aluno WHERE id = ?");
        // usamos a posição de cada ? para indicar o local de cada parâmetro
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            aluno.setId(rs.getInt("id"));
            aluno.setNome(rs.getString("nome"));
            aluno.setIdade(rs.getInt("idade"));
            aluno.setEstado(rs.getString("estado"));
        }

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }

    return aluno;
}
```

Na `Main`

```java
Aluno aluno = alunoDAO.getAlunosByID(4);
System.out.println(aluno);
```

```java
// inserir um aluno no banco
public void inserirAluno(Aluno aluno) {
	try(var conn = ConnectionFactory.getConnection()) {
        String sql = "INSERT INTO aluno(nome, idade, estado) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, aluno.getNome());
        stmt.setInt(2, aluno.getIdade());
        stmt.setString(3, aluno.getEstado());

        int linhaAlterada = stmt.executeUpdate();
        System.out.println("A linha alterada foi " + linhaAlterada);

    } catch (SQLException throwables) {
    throwables.printStackTrace();
    }
}
```

Na `Main`. Podemos usar o método anterior `getAlunosList()` para visualizar.

```java
Aluno alunoTemp = new Aluno("Anderson", 23, "PE");
alunoDAO.inserirAluno(alunoTemp);
```

```java
// remover um aluno pelo id
public void deletarAluno(int id) {
    try(var conn = ConnectionFactory.getConnection()) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        int linhaAlterada = stmt.executeUpdate();
        System.out.println("A linha alterada foi " + linhaAlterada);

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}
```

```java
// atualizar os dados de um aluno pelo id
public void atualizarAluno(int id) {
    try(var conn = ConnectionFactory.getConnection()) {
        String sql = "UPDATE aluno SET nome = 'Anderson Alencar' WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        int linhaAlterada = stmt.executeUpdate();
        System.out.println("A linha alterada foi " + linhaAlterada);

    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
}
```

## Trabalhando com JPA <a name="2"></a>

Existia um problema de produtividade com muito tempo gasto com JDBC, o desenvolvedor investia muito tempo em saber como buscar os dados ao invés de focar na regra de negócio, além da mudança de paradigma entre a orientação a objeto com o modelo relacional.

Pensando neste último problema, foi criado o **Mapeamento Objeto Relacional (ORM)** para representar tabelas através de classes. Assim, uma tabela era mapeada em uma classe, uma coluna em um atributo e um registro em um objeto. Portanto, foi criado uma padronização de implementações ORM conhecida como **JPA (Java Persistence API)**. 

Desse modo, o JPA fornece uma interface comum, porém cada implementação pode pode resolver um problema de forma diferente, mas seguindo certas restrições, sendo possível manter o código independente da implementação e ajudando a abstrair o código.

 ![image-20210316224133427](../attachments/image-20210316224133427.png)

![image-20210316224204030](../attachments/image-20210316224204030.png)

![image-20210316224248870](../attachments/image-20210316224248870.png)

![image-20210316224341647](../attachments/image-20210316224341647.png)

![image-20210316224421250](../attachments/image-20210316224421250.png)

![image-20210316224454462](../attachments/image-20210316224454462.png)