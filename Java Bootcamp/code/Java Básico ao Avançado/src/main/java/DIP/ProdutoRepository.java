package DIP;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepository {
    private MySqlConnection mySqlConnection;

    // dbConnection é a abstração do banco de dados
    // pode-se alterar o banco de dados sem alterar o código
    // o código depende da abstração e não da implementação
    private DbConnection dbConnection;

    public ProdutoRepository(MySqlConnection mySqlConnection) {
        this.mySqlConnection = mySqlConnection;
    }

    public ProdutoRepository(DbConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public List<Produto> buscarProdutos() {
        // retorna lista de produtos da base de dados
        return new ArrayList<>();
    }
}
