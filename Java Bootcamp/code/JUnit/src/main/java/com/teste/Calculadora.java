package com.teste;

public class Calculadora {
    public int somar (String exp) {
        int sum = 0;
        for (String summand: exp.split("\\+"))
            sum += Integer.valueOf(summand);
        return sum;
    }
}

