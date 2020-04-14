package org.jugistanbul.string.method;

import java.util.stream.Collectors;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 13.04.2020
 **/

public class NewUtilityMethods
{

    public static void main(String[] args){

        final var names = " Altug\nHuseyin\nTaner ";
        final var nameList = names.strip().lines().collect(Collectors.toList());
        nameList.forEach(System.out::println);

        System.out.println("\u2000");

        final var jugPart1 = "JUG\u2000";
        final var jugPart2 = " İstanbul";

        System.out.println(jugPart1.stripTrailing() + jugPart2.stripLeading());

        System.out.println("TB" + "M".repeat(2));
    }
}
