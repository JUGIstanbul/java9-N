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

    }
}
