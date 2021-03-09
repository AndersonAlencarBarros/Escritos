package Java11;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

public class Java11Http {
    public static void main(String[] args) throws IOException, InterruptedException {
        // Http client API atualizda que veio para substituir
        // a HttpUrlConnection legada, porque ela está antiga
        // e difícil de usar
        // A nova API suporta HTTP/1.1 e HTTP/2.0, além de suportar WebSocket
        // Requisição do tipo GET
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://andersonalencarbarros.github.io/alencarbarros.github.io/"))
                .build();

        // httpClient é responsável pela execução, quem faz a chamada
        HttpClient httpClient = HttpClient.newHttpClient();
        // aqui é indicado como quer receber a resposta
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.headers());
        System.out.println(response.body());





    }
}
