package org.jugistanbul.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 30.03.2020
 **/

public class StreamImprovements {

    private static final List<String> TURKISH_CHARACTERS = Arrays.asList("ç", "Ç", "ğ", "Ğ", "ı", "İ", "ş", "Ş", "ü", "Ü");
    private static Map<String, List<String>> dateOfRelease = new HashMap<>();

    static {
        dateOfRelease.put("Java 9", Arrays.asList("Modularity", "JShell", "Stream Improvements"));
        dateOfRelease.put("Java 10", Arrays.asList("Local Variable Type Inference",
                "Unmodifiable Collection Enhancements", "Container Awareness"));
        dateOfRelease.put("Java 11", Arrays.asList("Running Java File with single command",
                "New utility methods in String class", "JEP 321: HTTP Client"));
        dateOfRelease.put("Java 12", Arrays.asList("Switch Expressions(Preview)", "Default CDS Archives", "JVM constants API"));
        dateOfRelease.put("Java 13", Arrays.asList("Reimplement the Legacy Socket API", "Switch Expressions(Preview)", "Text Blocks(Preview)"));
        dateOfRelease.put(null, Arrays.asList(""));
        dateOfRelease.put("Java 14", Arrays.asList(" Pattern Matching for instanceof", "Records", "Helpful NullPointerExceptions"));
        dateOfRelease.put("Java 15", null);
    }

    public static class ListOwner
    {
        public String name;
        public List<Integer> points;

        public ListOwner(String name, List<Integer> points)
        {
            this.name = name;
            this.points = points;
        }

        public String getName()
        {
            return name;
        }

        public List<Integer> getPoints(){
            return points;
        }
    }

    public static void main(String[] args){

        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.takeWhile(n -> n < 6).forEach(System.out::print);

        System.out.println();

        Stream<String> alphabet = Stream.of("a", "b", "c", "ç", "e", "f", "g");
        alphabet.dropWhile(StreamImprovements::checkTurkishCharacter).forEach(System.out::print);

        System.out.println();
        IntStream.iterate(3, x -> x < 10, x -> x + 3).forEach(r -> System.out.print(r + " "));
        System.out.println("\n");

        System.out.println("JAVA 8 - Streaming null");
        try {

            dateOfRelease.entrySet()
                         .stream()
                         .flatMap(s -> s.getValue().stream())
                         .collect(Collectors.toList())
                         .forEach(System.out::println);

        } catch(NullPointerException e) {
            System.out.println("Throwed NullPointerException while streaming null");
        }

        System.out.println("JAVA 9 - Streaming null with ofNullable() method");
        dateOfRelease.entrySet().stream()
                     .flatMap(s -> Stream.ofNullable(s.getValue()))
                     .collect(Collectors.toList())
                     .forEach(System.out::println);
      
        System.out.println("\n");

        System.out.println("JAVA 8 - Not support Flat Mapping");
          List<ListOwner> owners = List.of(new ListOwner("Taner", List.of(1,2,3,4)),
                          new ListOwner("Altug", List.of(21,22,23,24)),
                          new ListOwner("Taner", List.of(31,32,33,34)));

          Map<String, List<List<Integer>>> ownerPoints =
                          owners.stream().collect(
                                          Collectors.groupingBy(
                                                          ListOwner::getName,
                                                          Collectors.mapping(
                                                                          ListOwner::getPoints,
                                                                          Collectors.toList())));
        System.out.println(ownerPoints);

        System.out.println("JAVA 9 - Collectors has flatMapping() method");
          Map<String, List<Integer>> ownerPoints2 =
                          owners.stream().collect(
                                          Collectors.groupingBy(
                                                          ListOwner::getName,
                                                          Collectors.flatMapping(
                                                                          owner -> owner.getPoints().stream(),
                                                                          Collectors.toList())));
       System.out.println(ownerPoints2);

        System.out.println("\n");


          List<Integer> numberList = List.of(1, 2, 3, 4, 4, 4, 4, 5, 5);

        System.out.println("JAVA 8 - Not support filtering while grouping");
          Map<Integer, Long> result = numberList.stream()
                          .filter(val -> val > 3)
                          .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
          System.out.println(result.toString());

        System.out.println("JAVA 9 - puts entries not matched to filter also in grouping result");
          result = numberList.stream()
                          .collect(Collectors.groupingBy(i -> i,
                                          Collectors.filtering(val -> val > 3, Collectors.counting())));
          System.out.println(result.toString());

    }

    private static boolean checkTurkishCharacter(String character){
        return !TURKISH_CHARACTERS.contains(character);
    }
}
