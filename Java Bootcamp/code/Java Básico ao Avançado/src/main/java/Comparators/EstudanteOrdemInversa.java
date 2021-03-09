package Comparators;

import java.util.Comparator;

public class EstudanteOrdemInversa implements Comparator<Estudante> {
    // Comparator serve para criar regras específicas
    // Externa a classe de domínio, para qualquer classe
    // Pode ser criada várias regras diferentes

    @Override
    public int compare(Estudante t1, Estudante t2) {
        return t2.getIdade() - t1.getIdade();
    }

}
