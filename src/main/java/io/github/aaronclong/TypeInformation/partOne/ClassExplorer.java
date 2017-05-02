package io.github.aaronclong.TypeInformation.partOne;

/**
 * Created by aaronlong on 5/2/17.
 */
public class ClassExplorer<T> {
    public ClassExplorer() {}

    public boolean classImplementsInterface(Object compareClass, Class<T> theInterface) {
        Class implementor = compareClass.getClass();
        return theInterface.isAssignableFrom(implementor);
    }

    public boolean classImplementsInterface(String compareClass, Class<T> theInterface) {
        try {
            Class implementor = Class.forName(compareClass);
            return theInterface.isAssignableFrom(implementor);

        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }

        return false;
    }

    public boolean classImplementsInterface(Class compareClass, Class<T> theInterface) {
        return theInterface.isAssignableFrom(compareClass);
    }


}
