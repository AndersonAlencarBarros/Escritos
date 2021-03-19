package JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main1 {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("part1-DIO");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // 2.1 - Criar instancias para serem adicionadas no banco de dados
        Aluno alunoParaAdicionar1 = new Aluno("Daniel", 29, "SP");
        Aluno alunoParaAdicionar2 = new Aluno("Carlos", 10, "AC");
        Aluno alunoParaAdicionar3 = new Aluno("Anderson", 23, "PE");


        // 2.2 - Iniciar uma trasacao para adiconar as instancias no banco de dados
        entityManager.getTransaction().begin();

        entityManager.persist(alunoParaAdicionar1);
        entityManager.persist(alunoParaAdicionar2);
        entityManager.persist(alunoParaAdicionar3);

        entityManager.getTransaction().commit();

        // 3 - Resgatar instâncias no banco de dados
        // para ler os dados não necessita de transação
        Aluno alunoEncontrado = entityManager.find(Aluno.class, 3);
        System.out.println(alunoEncontrado);

        // 4 - Alterar uma entidade
        entityManager.getTransaction().begin();

        alunoEncontrado.setNome("Karam");
        alunoEncontrado.setIdade(20);

        entityManager.getTransaction().commit();

        // 5 - Remover uma entidade
        entityManager.getTransaction().begin();

        entityManager.remove(alunoEncontrado);

        entityManager.getTransaction().commit();

        // 6 - Encerrar o gerenciador de entidades e encerrar a fabrica de gerenciadores de entidade.
        entityManager.close();
        entityManagerFactory.close();
    }
}
