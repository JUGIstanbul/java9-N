package org.jugistanbul.nested;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 14.04.2020
 **/
public class NestedAccessByReflection
{

    public void myPublic() {
        System.out.println("ParentClass->myPublic()");
    }

    private void myPrivate() {
        System.out.println("ParentClass->myPrivate()");
    }

    public Nested getNested() {
        return new Nested();
    }

    public class Nested {

        public void callNested() {
            // myPrivate();

//            { // not works
//                try {
//                    Method privateMethod = NestedAccessByReflection.class
//                                                                    .getDeclaredMethod("myPrivate");
//                    privateMethod.invoke(privateMethod);
//                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
//                    e.printStackTrace();
//                }
//            }

            { // works
                try {
                    Method publicMethod = Nested.class
                                                .getNestHost()
                                                .getDeclaredMethod("myPublic");
                    publicMethod.invoke(NestedAccessByReflection.this);

                    Method privateMethod = Nested.class
                                                .getNestHost()
                                                .getDeclaredMethod("myPrivate");
                    privateMethod.invoke(NestedAccessByReflection.this);

                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        var main = new NestedAccessByReflection();
        var nested = main.getNested();
        nested.callNested();
    }
}
