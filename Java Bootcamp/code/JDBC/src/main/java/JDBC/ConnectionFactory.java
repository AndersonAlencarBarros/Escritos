package JDBC;

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
