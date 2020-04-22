package org.jugistanbul.record;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 22.04.2020
 **/

record Person(String firstName, String lastName) implements Developer {

    public Person(){
        this("", "");
    }

    //Redefining an Accessor
    /*
        public String firstName(){
            return "The first name is " + firstName;
        }
    */

    @Override
    public String getFullName() {
        return String.join(" ", firstName, lastName);
    }

    public String specialMethod(){
        return "This is a special method";
    }
}
