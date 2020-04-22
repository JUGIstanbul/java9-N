package org.jugistanbul.patternmatching;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 22.04.2020
 **/

public class PatternMatchingExample
{
    public static void main(String[] args){
        System.out.println(howMuch(new Developer()));
    }

    private static int howMuch(Object o){

        if(o instanceof Developer dev){
            return dev.salary();
        } else if(o instanceof Boss boss) {
            return boss.profit();
        }

        return 0;
    }
}
