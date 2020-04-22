package org.jugistanbul.record;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 22.04.2020
 **/

public class RecordExample
{
    public static void main(String[] args){

        var huseyin = new Person("Huseyin", "Akdogan");
        var taner = new Person("Taner", "Diler");
        var noname = new Person();

        if(!huseyin.getFullName().equals(taner.getFullName())){
            System.out.println("Names are different");
        }

        System.out.println(huseyin.getFullName());
        System.out.println(taner.getFullName());
        System.out.println(noname.getFullName());

        System.out.println(huseyin.toString());
        System.out.println(taner.toString());
        System.out.println(noname.toString());

        System.out.println(huseyin.hashCode());
        System.out.println(taner.hashCode());
        System.out.println(noname.hashCode());
    }
}
