package JDBC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    // Classe responsável por acessar o banco

    public List<Aluno> getAlunosList() {
        List<Aluno> alunos = new ArrayList<>();

        try(var conn = ConnectionFactory.getConnection()) {
            PreparedStatement psrt = conn.prepareStatement("SELECT * FROM aluno");
            ResultSet rs = psrt.executeQuery();

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

    public Aluno getAlunosByID(int id) {
        Aluno aluno = new Aluno();
        try(var conn = ConnectionFactory.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM aluno WHERE id = ?");
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
}
