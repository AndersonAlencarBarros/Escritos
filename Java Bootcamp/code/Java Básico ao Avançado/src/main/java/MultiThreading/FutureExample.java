package MultiThreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureExample {
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        Casa casa = new Casa(new Quarto());
        // Runnable - execute() não tem um retorno e não lança uma exceção
        // Callable - call() pode retorna um valor e pode lançar exceções
        //
        casa.obterAfazeresDaCasa().forEach(atv -> threadPool.execute(() -> {
            try {
                atv.realizar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        threadPool.shutdown();
    }
}

interface Atividade {
        void realizar() throws InterruptedException;
}

abstract class Comodo {
        abstract List<Atividade> obterAfazeresDoComodo();
}

class Casa {
        private List<Comodo> comodos;

        Casa(Comodo... comodos) {
            this.comodos = Arrays.asList(comodos);
        }

        List<Atividade> obterAfazeresDaCasa() {
            return this.comodos.stream()
                    .map(Comodo::obterAfazeresDoComodo)
                    .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                        pivo.addAll(atividades);
                        return pivo;
                    });
        }
}

class Quarto extends Comodo {

    @Override
    List<Atividade> obterAfazeresDoComodo() {
        return Arrays.asList(
                this::arrumarGuardaRoupa,
                this::arrumarCama,
                this::varrerOQuarto
        );
    }

    private void arrumarGuardaRoupa() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Arrumar Guarda Roupa");
    }

    private void arrumarCama() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Arrumar Cama");
    }

    private void varrerOQuarto() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Varrer o Quarto");
    }
}





