package org.jugistanbul.var;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 4.04.2020
 **/

public class LocalVariableTypeInference
{
    public static void main(String[] args) throws IOException {

        var text = "Hello Java 10";
        if(text instanceof String){
            System.out.println("The type is String!");
        }

        System.out.println("\n");

        var personList = new ArrayList<>();
        personList.add(new Person("Hüseyin", "Akdoğan"));
        personList.add(new Person("Taner", "Diler"));

        //In this way, we can't access the person class attributes
        //personList.stream().filter(e -> e.getFirstName()...

        var explicitPersonList = List.of(new Person("Hüseyin", "Akdoğan"), new Person("Taner", "Diler"));
        explicitPersonList.stream().filter(e -> e.getFirstName().contains("e")).forEach(e -> System.out.println(e.getFirstName()));

        System.out.println("\n");

        //This is a bad use
        var result = Helper.process();
    }
}

class Person
{
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

class Helper
{
    public static long process() throws IOException {
        var lines = Files.lines(Paths.get("java10/src/main/resources/log.txt"));
        return lines.count();
    }
}
