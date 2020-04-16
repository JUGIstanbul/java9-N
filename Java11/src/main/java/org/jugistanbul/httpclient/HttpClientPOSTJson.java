package org.jugistanbul.httpclient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientPOSTJson {
    private static void sendPost() throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        // json formatted data
        String json = new StringBuilder()
                .append("{")
                .append("\"jug\":\"JUG Istanbul\",")
                .append("\"message\":\"Hello Java Lovers\"")
                .append("}").toString();

        // add json header
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create("https://httpbin.org/post"))
                .setHeader("X-JUG-NAME", "JUG ISTANBUL") // add request header
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        // print status code
        System.out.println(response.statusCode());

        // print response body
        System.out.println(response.body());

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        sendPost();
    }
}
