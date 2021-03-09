package Comparators;

public class Estudante implements Comparable<Estudante>{
    private String nome;
    private int idade;

    public Estudante(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    //    É obrigatório retornar 3 tipos de valores:
    //    positivo, se o objeto atual for maior em uma escala de ordenação
    //    negativo, se o objeto atual é menor
    //    e 0 se ambos são iguais
    @Override
    public int compareTo(Estudante estudante) {
        int i = this.getIdade() - estudante.getIdade();
        return i;
    }
}
