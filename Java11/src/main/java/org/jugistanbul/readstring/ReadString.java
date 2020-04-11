package org.jugistanbul.readstring;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 11.04.2020
 **/

public class ReadString
{
    private static final String FILE_PATH = "java11/src/main/resources/meetups.txt";

    public static void main(String[] args) throws IOException {
        final var content = Files.readString(Paths.get(FILE_PATH));
        System.out.println(content);
    }

}