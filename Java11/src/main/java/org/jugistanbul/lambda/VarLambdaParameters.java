package org.jugistanbul.lambda;

import java.util.function.Predicate;
import java.util.stream.IntStream;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 13.04.2020
 **/

public class VarLambdaParameters
{
    public static void main(String[] args){

        IntStream.of(1, 2, 3, 5, 6, 7, 8, 9, 10)
                .filter((var i) -> i % 3 == 0)
                .forEach(System.out::println);

        System.out.println();

        Predicate<Apple> pApple = (var a) -> a.getWeight() > 50;

        var myApple = new Apple("Green", 100);
        var message = pApple.test(myApple)
                ?"This apple weighs at least 50 grams"
                :"This apple is lighter than 50 grams";

        System.out.println(message);
    }
}

class Apple
{
    private String type;
    private int weight;

    public Apple(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
