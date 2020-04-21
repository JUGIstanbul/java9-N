package org.jugistanbul.text;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 21.04.2020
 **/

public class TextBlocksExample
{
    public static void main(String[] args){

        var html = """
                <html>
                    <body>
                        <p>Hello, World</p>
                    </body>
                </html>
				""";

        var json = """
                {
                    "organization":"JUG İstanbul",
                    "event": "Java 9 to 14",
                    "session": 4
                    "name": "Java 13 and 14"
                }
                """;

        System.out.println(html + "\n" + "*".repeat(20) + "\n\n" +  json);
    }
}
