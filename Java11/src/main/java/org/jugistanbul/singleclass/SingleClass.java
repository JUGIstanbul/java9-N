package org.jugistanbul.singleclass;

public class SingleClass {

    private static class StaticNestedClass {
        public void say() {
            System.out.println("Hi, I'm Staitc Nested Class!!!");
        }
    }

    public void say() {
        System.out.println("Hi, I'm Main Class!!!");
    }

    public static void main(String[] args) {
        var nested = new StaticNestedClass();
        var main = new SingleClass();
        main.say();
        nested.say();
    }
}
