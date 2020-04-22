package org.jugistanbul.nullpointer;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 21.04.2020
 **/

public class HelpfulNullPointer
{
    public static void main(String[] args){

        var model = new Model();
        var car = new Car("White", model);

        System.out.println(car.getModel().getFactory().getName());

        /*
            Before Java 14, we were getting the following message in such this situation

            Exception in thread "main" java.lang.NullPointerException at
            org.jugistanbul.nullpointer.HelpfulNullPointer.main(HelpfulNullPointer.java:15)

            With Java 14 Helpful NullPointerExceptions feature, we receive the message below

            Exception in thread "main" java.lang.NullPointerException:
            Cannot invoke "org.jugistanbul.nullpointer.Factory.getName()"
            because the return value of "org.jugistanbul.nullpointer.Model.getFactory()" is null
            at org.jugistanbul.nullpointer.HelpfulNullPointer.main(HelpfulNullPointer.java:15)

            You must use the -XX:+ShowCodeDetailsInExceptionMessages command-line option
            to enable detailed exception message feature because it's disabled by default.
        */
    }
}
