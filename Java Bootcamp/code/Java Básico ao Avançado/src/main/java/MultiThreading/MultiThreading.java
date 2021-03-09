package MultiThreading;

public class MultiThreading {
    public static void main(String[] args) {
        GeradorPDF geradorPDF = new GeradorPDF();
        BarradeCarregamento barradeCarregamento = new BarradeCarregamento(geradorPDF);

        geradorPDF.start();
        barradeCarregamento.start();

    }
}

// Uma forma de fazer uma thread, herdando a classe Thread
class GeradorPDF extends Thread {

    @Override
    public void run() {
        try {
            System.out.println("Iniciado!");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Gerado o PDF");
    }
}

class BarradeCarregamento extends Thread {
    private Thread geradorPDF;

    public BarradeCarregamento(Thread geradorPDF) {
        this.geradorPDF = geradorPDF;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (!geradorPDF.isAlive()) {
                break;
            }
            System.out.println("Loading...");
        }
    }
}