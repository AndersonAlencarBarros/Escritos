package Interfaces;

public class Fiesta implements  Carro, Veiculo{
    @Override
    public String marca() {
        return "Ford";
    }

    @Override
    public String registro() {
        return "FDFAD659669";
    }

    public void ligar() {
        Carro.super.ligar();
        Veiculo.super.ligar();
    }
}
