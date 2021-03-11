package com.teste;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    @Test
    public void somarTeste() {
        Calculadora calculadora = new Calculadora();
        int soma = calculadora.somar("1+2");

        assertEquals(3, soma);
    }
}
