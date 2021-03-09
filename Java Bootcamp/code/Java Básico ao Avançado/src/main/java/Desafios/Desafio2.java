import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.Pattern;

//  Validador de senhas com requisitos
public class Desafio2 {
    static String string;

    static public boolean temLetraMaiuscula () {
        final String regex = "([A-Z])";
        final Pattern pattern = Pattern.compile(regex);

//        System.out.println("temLetraMaiuscula: " + pattern.matcher(string).find());
        return pattern.matcher(string).find();
    }

    static public boolean temLetraMinuscula () {
        final String regex = "([a-z]+)";
        final Pattern pattern = Pattern.compile(regex);

//        System.out.println("temLetraMinuscula: " + pattern.matcher(string).find());
        return pattern.matcher(string).find();
    }

    static public boolean temNumero () {
        final String regex = "([0-9]+)";
        final Pattern pattern = Pattern.compile(regex);

//        System.out.println("temNumero: " + pattern.matcher(string).find());
        return pattern.matcher(string).find();
    }

    static public boolean verificaSeNaoTemEspaços () {
        final String regex = "(\\s+)";
        final Pattern pattern = Pattern.compile(regex);

//        System.out.println("verificaSeNaoTemEspaços: " + !pattern.matcher(string).find());
        return !pattern.matcher(string).find();
    }

    static public boolean verificaSeNãoTemPontuação() {
        final String regex = "[!\"\\#$%&'()*+,\n" +
                "\\-./:;<=>?@\\[\n" +
                "\\\\\\]^_‘{|}~]";
        final Pattern pattern = Pattern.compile(regex);

//        System.out.println("verificaPontuação: " + !pattern.matcher(string).find());
        return !pattern.matcher(string).find();
    }

    static public boolean verificaOTamanho () {
        return string.length() >= 6 && string.length() <= 32;
    }

    static public boolean validarSenhas () {
        return temLetraMinuscula() && temLetraMaiuscula() && temNumero()
                && verificaSeNaoTemEspaços() && verificaSeNãoTemPontuação()
                && verificaSeNãoTemPontuação() && verificaOTamanho();
    }

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (( string = in.readLine()) != null) {

            if (validarSenhas()) {
                System.out.println("Senha valida.");
            } else
                System.out.println("Senha invalida.");
        }
    }
}