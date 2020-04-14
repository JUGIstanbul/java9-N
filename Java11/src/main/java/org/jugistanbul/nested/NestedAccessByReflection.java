package org.jugistanbul.nested;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hakdogan (hakdogan@kodcu.com)
 * Created on 14.04.2020
 **/

public class NestedAccessByReflection
{
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {

        var nestedAccess = new NestedAccessByReflection();
        nestedAccess.callMethodOfNestedObject();
    }

    public void callMethodOfNestedObject() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        var object = new NestedObject();
        object.nestedPublic();
    }

    private void myPrivate() {
        System.out.println("myPrivate");
    }

    class NestedObject {

        public void nestedPublic() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
            //myPrivate(); this is possible

            var access = new NestedAccessByReflection();
            Method method = access.getClass().getNestHost().getDeclaredMethod("myPrivate");
            method.invoke(access); //but this isn't possible before java 11
        }
    }
}
