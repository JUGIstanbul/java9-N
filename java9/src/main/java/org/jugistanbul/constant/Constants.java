package org.jugistanbul.constant;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 31.03.2020
 **/

public class Constants
{
    public static Map<String, String> turkishCharacters = new HashMap<>();
    public static Map<String, List<String>> versionsAndFutures = new HashMap<>();

    static {

        turkishCharacters.put("ç", "c");
        turkishCharacters.put("Ç", "c");
        turkishCharacters.put("ğ", "g");
        turkishCharacters.put("Ğ", "g");
        turkishCharacters.put("ı", "i");
        turkishCharacters.put("ş", "s");
        turkishCharacters.put("Ş", "s");
        turkishCharacters.put("ü", "u");
        turkishCharacters.put("Ü", "u");

        versionsAndFutures.put("Java 9", Arrays.asList("Modularity", "JShell", "Stream Improvements"));
        versionsAndFutures.put("Java 10", Arrays.asList("Local Variable Type Inference",
                "Unmodifiable Collection Enhancements", "Container Awareness"));
        versionsAndFutures.put("Java 11", Arrays.asList("Running Java File with single command",
                "New utility methods in String class", "JEP 321: HTTP Client"));
        versionsAndFutures.put("Java 12", Arrays.asList("Switch Expressions(Preview)", "Default CDS Archives", "JVM constants API"));
        versionsAndFutures.put("Java 13", Arrays.asList("Reimplement the Legacy Socket API", "Switch Expressions(Preview)", "Text Blocks(Preview)"));
        versionsAndFutures.put("Java 14", Arrays.asList(" Pattern Matching for instanceof", "Records", "Helpful NullPointerExceptions"));
        versionsAndFutures.put("Java 15", null);
    }
    private Constants(){}
}
