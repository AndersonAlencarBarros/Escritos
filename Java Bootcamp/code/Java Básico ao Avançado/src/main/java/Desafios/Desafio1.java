package Desafios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

//  Abreviando posts do blog
public class Desafio1 {

    static String entrada;
    static List<String> listaDePalavras;
    static List<String> alfabeto = new ArrayList<>();
    static Map<String, Map<String, Integer>> repetições;
    static Map<String, String> resposta;

    public static void prepararEstruturasDeDados()
    {
        // aloca espaço para essas estruturas que também precisam ser limpam a cada entrada
        repetições = new HashMap<String, Map<String, Integer>>();
        resposta = new HashMap<>();
        listaDePalavras = new ArrayList<>(List.of(entrada.split(" ")));

        // Coloca todas as letras do alfabeto em um ArrayList para iterações posteriores,
        // adiciona o alfabeto e HashMaps vazios em repetições
        // e preenche o HashMap de resposta com o alfabeto de strings vazias

        for (char letra = 'a'; letra <= 'z'; letra++)
        {
            var ch = String.valueOf(letra);
            repetições.put(ch, new HashMap<String, Integer>());
            resposta.put(ch, "");
        }

        // associa zero a todas as palavras nos Hashmap de repetições
        // para que posteriormente seja calculado as repetições
        listaDePalavras.stream()
            .forEach(p -> {
                repetições.get(p.substring(0,1)).put(p, 0);
            });
    }

    public static void extrairRepetiçõesDeCadaPalavra()
    {
        alfabeto.stream().forEach(ch -> {
            listaDePalavras.stream()
                .forEach(p -> {
                    repetições.computeIfPresent(ch, (k,v) -> {
                        v.computeIfPresent(p, (k1, v1) -> v1 + 1);
                        return v;
                    });
                });
        });
    }

    public static void obterMelhorSubstituição()
    {
        alfabeto.stream()
            .forEach(ch -> {
                int totalDeCaracteresDeUmaLetra = repetições.get(ch).keySet().stream()
                        .mapToInt(
                                // calcula-se o total de caracteres por letra multiplicando o tamanho da palavra pela repetição
                                t -> repetições.get(ch).get(t) * t.length()
                        ).sum();

                // necessário o wrapper, pois é impossível alterar variáveis externas ao lambda
                var wrapper = new Object(){ int melhorCasoDeSubstituicao = Integer.MAX_VALUE; };
                repetições.get(ch).entrySet().stream()
                       .forEach(entry -> {
                           var palavra = entry.getKey();
                           var repeticaoDeUmaPalavra = entry.getValue();

                           // Subtrai-se o total de caracteres de uma letra
                           // pela multiplicação da repetição de uma palavra com o tamanho da palavra
                           // e soma-se a repetição da palavra multiplicado por 2, pois
                           // quando substitui-se fica da seguinte maneira p. ocupando 2 caracteres
                           // Daí, temos o quanto cada palavra economiza de espaço
                           // e assim, a palavra com o menor valor é o que queremos substituir
                           // Exemplo, temos abcdef abc abc abc, se substitui abcdef economiza 4 letras
                           // caso substituísse abc abc abc, teríamos uma economia de 3 letras,
                           // porém se tivesse abcdef abc abc abc abc abc abc, substituindo abc abc abc abc abc abc
                           // economizaria 6 letras, o que seria mais vantajoso.

                           var aux = ((totalDeCaracteresDeUmaLetra - repeticaoDeUmaPalavra * palavra.length())
                                   + 2 * repeticaoDeUmaPalavra);

                           if (wrapper.melhorCasoDeSubstituicao > aux && (palavra.length() > 2)) {
                               wrapper.melhorCasoDeSubstituicao = aux;
                               resposta.put(ch, palavra);
                           }
                       });
            });
    }

    public static void printResposta()
    {
        // Determina a string com as substituições
        StringBuilder stringResposta = new StringBuilder();

        for (var palavra : listaDePalavras) {
            var ch = palavra.substring(0,1);
            String aux = resposta.get(ch).equals(palavra) ? ch + "." : palavra;
            stringResposta.append(aux + " ");
        }

        stringResposta.deleteCharAt(stringResposta.length() - 1);

        // Determina o total de abreviações/substituições
        int totalDeSubstituições = 0;
        for (var ch : alfabeto)
            if(!resposta.get(ch).isEmpty())
                totalDeSubstituições++;

        // Põe tudo na saída
        System.out.println(stringResposta);
        System.out.println(totalDeSubstituições);

        for (var ch : alfabeto)
            if(!resposta.get(ch).isEmpty())
                System.out.println(ch + ". = " + resposta.get(ch));
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        entrada = br.readLine();

        for (char letra = 'a'; letra <= 'z'; letra++) {
            var ch = String.valueOf(letra);
            alfabeto.add(ch);
        }

        while (!entrada.equals("."))
        {
            prepararEstruturasDeDados();
            extrairRepetiçõesDeCadaPalavra();
            obterMelhorSubstituição();
            printResposta();

            entrada = br.readLine();
        }
    }
}
