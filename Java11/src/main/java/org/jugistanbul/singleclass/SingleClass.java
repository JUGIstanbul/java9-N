package org.jugistanbul.singleclass;

public class SingleClass {

    private static class InnerClass {
        public void say() {
            System.out.println("Hi, I'm Inner Class!!!");
        }
    }

    public void say() {
        System.out.println("Hi, I'm Main Class!!!");
    }

    public static void main(String[] args) {
        var inner = new InnerClass();
        var main = new SingleClass();
        main.say();
        inner.say();
    }
}
