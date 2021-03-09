package ParadigmaFuncional;

import Debug.IMC;
import Debug.Pessoa;

import java.util.function.DoubleSupplier;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        // Supplier não recebem parâmetros e apenas retornam valores
        Supplier<Pessoa> sup = () -> new Pessoa("Anderson", 1.77, 70.0);
        // Apenas funciona se a classe não precisar de nenhum parâmetro
        Supplier<IMC> sup1 = IMC::new;

        Supplier<Double> doubleSupplier1 = () -> Math.random();
        DoubleSupplier doubleSupplier2 = Math::random;

        System.out.println(doubleSupplier1.get());
        System.out.println(doubleSupplier2.getAsDouble());

        // Supplier apensar retorna algo com o get()
        System.out.println(sup.get());
    }
}
