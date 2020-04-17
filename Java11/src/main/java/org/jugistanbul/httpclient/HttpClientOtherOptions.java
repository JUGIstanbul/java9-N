package org.jugistanbul.httpclient;

import java.net.*;
import java.net.http.HttpClient;
import java.time.Duration;

public class HttpClientOtherOptions
{
    private static void sendPost() {

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

    public static void main(String[] args)  {
        sendPost();
    }
}
