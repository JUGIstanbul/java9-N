package org.jugistanbul.string.write;

import org.jugistanbul.string.read.ReadString;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 17.04.2020
 **/

public class WriteString
{
    private static final String FILE_PATH = "java11/src/main/resources/meetups.txt";

    public static void main(String[] args) throws IOException {

        System.out.println(ReadString.readString(FILE_PATH));
        System.out.println("****************************\n");

        var path = Paths.get(FILE_PATH);
        Files.writeString(path, "\nHello World !!", StandardOpenOption.APPEND);

        System.out.println(ReadString.readString(FILE_PATH));
    }
}
