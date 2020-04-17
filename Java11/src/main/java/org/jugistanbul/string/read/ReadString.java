package org.jugistanbul.string.read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 11.04.2020
 **/

public class ReadString
{
    public static String readString(final String path) throws IOException {
        return Files.readString(Paths.get(path));
    }

}