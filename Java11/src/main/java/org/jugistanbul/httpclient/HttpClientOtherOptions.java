package org.jugistanbul.httpclient;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class HttpClientOtherOptions {
    private static void sendPost() throws IOException, InterruptedException {

        // Authanticator
        HttpClient httpClient1 = HttpClient.newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "user",
                                "password".toCharArray());
                    }
                })
                .build();
        // Connection time out
         HttpClient httpClient2 = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(5))
                .build();

         // Set a proxy
        HttpClient httpClient3 = HttpClient.newBuilder()
                .proxy(ProxySelector.of(new InetSocketAddress("your-company-proxy.com", 8080)))
                .build();

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        sendPost();
    }
}
