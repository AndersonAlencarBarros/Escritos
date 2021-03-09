package Interfaces;

import Enums.Status;
import Enums.TipoVeiculo;

public class Programa {
    public static void main(String[] args) {
//        Interfaces.Gol gol = new Interfaces.Gol();
//        Interfaces.Carro golCar = new Interfaces.Gol();
//
//        System.out.println(gol.marca());
//        gol.ligar();
//
//        Interfaces.Trator t = new Interfaces.Trator();
//        Interfaces.Veiculo t1 = new Interfaces.Trator();
//
//        System.out.println(t.registro());
//        t.ligar();
//
//        System.out.println();
//        System.out.println("Interfaces.Fiesta");
//        Interfaces.Fiesta f = new Interfaces.Fiesta();
//        f.ligar();

        System.out.println(TipoVeiculo.TERRESTE);
        System.out.println(TipoVeiculo.AQUATICO);

        for(TipoVeiculo t : TipoVeiculo.values())
            System.out.println(t);

        System.out.println();
        System.out.println(Status.OPEN.getCod());
        System.out.println(Status.OPEN.getText());

    }
}
