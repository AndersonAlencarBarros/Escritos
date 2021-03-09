package Collections;

import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<Double> notasAlunos = new HashSet<>();

        notasAlunos.add(3.4);
        notasAlunos.add(10.0);
        notasAlunos.add(5.2);
        notasAlunos.add(1.1);
        notasAlunos.add(7.4);

        notasAlunos.remove(1.1);


        var it = notasAlunos.iterator();
        while (it.hasNext())
            System.out.println(it.next());

        for (var d : notasAlunos)
            System.out.println("-> " + d);

        notasAlunos.clear();

        System.out.println(notasAlunos.isEmpty());
    }
}
