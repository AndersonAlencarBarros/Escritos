package JDBC;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> alunos = alunoDAO.getAlunosList();
        alunos.stream().forEach(System.out::println);
//
//        JDBC.Aluno aluno = alunoDAO.getAlunosByID(4);
//        System.out.println(aluno);
//
//        JDBC.Aluno alunoTemp = new JDBC.Aluno("Anderson", 23, "PE");
//        alunoDAO.inserirAluno(alunoTemp);

//        alunoDAO.deletarAluno(1);

//        alunoDAO.atualizarAluno(5);

//        alunos.stream().forEach(System.out::println);
    }
}
