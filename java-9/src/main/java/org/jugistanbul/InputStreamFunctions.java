package org.jugistanbul;

import java.io.*;
import java.net.URL;

/**
 * Created by taner on 06.04.2017.
 */
public class InputStreamFunctions
{
    public static void main(String[] args) throws IOException
    {

        URL url = InputStreamFunctions.class.getClassLoader().getResource("lorem.txt");
        String filePath = url.getPath();
        InputStream is = new BufferedInputStream(
                new FileInputStream(new File(filePath)));

        // Read all bytes. While doing, blocks until the requested number of bytes have been read, end
        // of stream is detected, or an exception is thrown
        byte[] allBytes = is.readAllBytes();



        is = new BufferedInputStream(
                new FileInputStream(new File(filePath)));

        // Transfer data from inputStream to outputstream
        is.transferTo(System.out);
    }

}
