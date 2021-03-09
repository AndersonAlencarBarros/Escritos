package Strings;

public class Main {
    public static void main(String[] args) {
        var nome = "Anderson";
        var sobreNome = "Alencar";
        var nomeCompleto = nome + sobreNome;

        var s = "Minha String";
        System.out.println(s.charAt(5));            // retorna o caractere da posição
        System.out.println(s.length());             // tamanho da string
        System.out.println(s.trim());               // remove caracteres em branco
        System.out.println(s.toLowerCase());        // tudo minúsculo
        System.out.println(s.toUpperCase());        // tudo maiúsculo
        System.out.println(s.contains("M"));        // verifica se contém
        System.out.println(s.replace("n", "$")); // substitui todos os caractere encontrados
        System.out.println(s.equals("MinhaString")); // verifica se é igual
        System.out.println(s.equalsIgnoreCase("minhastring")); // verifica se é igual, sem case sensitive
        System.out.println(s.substring(1,6));        // obtém uma substring neste intervalo

        var msg = String.format("O cliente %s pediu...", nomeCompleto);
        System.out.println(msg);

        var sb = new StringBuilder(nome);
        System.out.println(sb.append("Barros")); // contatena uma string
        System.out.println(sb.reverse());  // reverte uma string
        System.out.println(sb.insert(sb.length(), "#")); // insere uma string em uma posição

        var alfabeto = "A B C D";
        var char_array = alfabeto.toCharArray(); // converte a string em um vetor de caracteres
        for (char c : char_array)
            System.out.println(c);


        var aula = "Aula de Java";
        var words = aula.split(" ");
        for (var i : words)
            System.out.println(i);

        var t = "1234 asda qw";
        var resultReplaceAll = t.replaceAll("\\s", "@");
        System.out.println(resultReplaceAll);

    }
}
