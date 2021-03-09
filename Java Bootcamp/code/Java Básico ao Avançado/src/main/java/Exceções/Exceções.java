package Exceções;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exceções {
    public void abrirArquivo() {
        try {
            new java.io.FileInputStream("arquivo.txt");
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Não foi possível abrir o arquivo");
        }

//        try {
//            PreparedStatement stmt = con.prepareStatement(query);
//            ...
//        } catch (SQLException e) {
//            throw new AcessoADadosException("Problema na criação do Statement", e);
//        }
    }

    public static void main(String[] args) {
//        try {
//            Carro carro = new Carro();
//            carro.getPlaca();
//        } catch (IntegrationException e) {
//            throw new BusinessException("Erro na criação do objeto", e);
//        } finally {
//
//        }


        // try-catch-resouces - onde passa um parâmetro para o try()
        // assim não é mais necessário fechar os recursos abertos
        // com o bloco finally
//        try(var bufferedReader1 = new BufferedReader(new InputStreamReader(urlConnection1.getInputStream()))) {
//            System.out.println(bufferedReader1.lines().collect(Collectors.joining()).replaceAll(">", ">\n"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
