package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    public static void main(String[] args) throws SQLException {
        String driver = "postgresql";
        String dataBaseAddress = "localhost";
        String dataBaseName = "dio";
        String user = "postgres";
        String password = "12345";

        String urlConnection = "jdbc:"  + driver
                                + "://" + dataBaseAddress
                                + "/"   + dataBaseName;

        try (Connection conn = DriverManager.getConnection(urlConnection, user, password)) {
            System.out.println("Banco Conectado com Sucesso");
        } catch (Exception e) {
            System.out.println("Banco Não Conectado");
        }


    }
}
