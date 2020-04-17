package org.jugistanbul.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class HttpClientAsyncGET {
    private static void sendGET() throws InterruptedException, TimeoutException, ExecutionException {

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://httpbin.org/get"))
                .setHeader("X-JUG-NAME", "JUG ISTANBUL") // add request header
                .build();


        CompletableFuture<HttpResponse<String>> response = httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString());

        String responseBody = response.thenApply(HttpResponse::body).get(15, TimeUnit.SECONDS);

        System.out.println(responseBody);
    }

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        sendGET();
    }
}
