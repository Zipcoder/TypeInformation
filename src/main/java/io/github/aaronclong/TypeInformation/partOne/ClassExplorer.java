package io.github.aaronclong.TypeInformation.partOne;

import com.sun.xml.internal.messaging.saaj.soap.impl.FaultElementImpl;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.regex.Pattern;
//import java.util.regex.Matcher;


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

    public String listAllMembers(Object obj) {
        Class objMetaData = obj.getClass();
        StringBuilder builder = new StringBuilder(1000);
        Constructor[] constructors = objMetaData.getConstructors();
        Field[] fields = objMetaData.getFields();
        Method[] methods = objMetaData.getMethods();
        for (Constructor constructor : constructors) {
            append(builder, constructor.toString());
        }
        for (Field field : fields) {
            append(builder, field.toString());
        }
        for (Method method : methods) {
            append(builder, method.toString());
        }
        System.out.println(builder.toString());
        return builder.toString();
    }

    private void append(StringBuilder builder, String stuff) {
        builder.append(stuff);
        builder.append("\n");
    }

}
