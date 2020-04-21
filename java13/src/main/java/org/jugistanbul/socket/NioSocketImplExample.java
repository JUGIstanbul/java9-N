package org.jugistanbul.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 21.04.2020
 **/

public class NioSocketImplExample
{
    public static final byte[] RESPONSE = (
            """
               HTTP/1.1 200 OK
               Content-length: 2
               
               OK
               """).getBytes();

    public static void main(String[] args){
        
        try (ServerSocket serverSocket = new ServerSocket(8080, 100)){

            while(!Thread.currentThread().isInterrupted()){
                final var client = serverSocket.accept();
                try(BufferedReader reader = new BufferedReader(
                        new InputStreamReader(client.getInputStream()))){

                    var line = reader.readLine();
                    while (line != null && !line.isEmpty()) {
                        line = reader.readLine();
                        System.out.println(line);
                    }
                    client.getOutputStream().write(RESPONSE);
                    client.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
