package Debug;

import java.util.Objects;

public class Pessoa {
    private String nome;
    private Double altura;
    private Double peso;

    public Pessoa(String nome, Double altura, Double peso) {
        this.nome = nome;
        this.altura = altura;
        this.peso = peso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public Double getAltura() {
        return altura;
    }

    public Double getPeso() {
        return peso;
    }

    public int hashCode() {
        return Objects.hash(this.nome, this.altura, this.peso);
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", altura=" + altura +
                ", peso=" + peso +
                '}';
    }
}
