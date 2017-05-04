package io.github.aaronclong.TypeInformation.partOne;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

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
        //System.out.println(builder.toString());
        return builder.toString();
    }

    private void append(StringBuilder builder, String stuff) {
        builder.append(stuff);
        builder.append("\n");
    }

    public String getClassHierarchy(Object obj) {
        ArrayList<String> classHierarchy = new ArrayList();
        Class objClassRef = obj.getClass();
        while (objClassRef != null) {
            classHierarchy.add(objClassRef.toString());
            objClassRef = objClassRef.getSuperclass();
        }
        return format(classHierarchy);
    }

    public String format(ArrayList<String> unformatedList) {
        StringBuilder builder = new StringBuilder(1000);
        int size = unformatedList.size()-1;
        for (int i = size; i >=0; i--) {
            int howManySpaces = size - i;
            addSpaces(builder, howManySpaces);
            builder.append(unformatedList.get(i));
            builder.append("\n");
        }
        return builder.toString();
    }

    private void addSpaces(StringBuilder builder, int interval) {
        String space = " ";
        for (int z = 0; z < interval; z++) builder.append(space);
    }

    public List instantiateClassHierarchy(Object obj) {
        ArrayList<Object> objectNeutralArray = new ArrayList<Object>();
        Class objReference = obj.getClass();
        while (objReference != null) {
            Class nextLevel = objReference.getSuperclass();
            Object tmp = makeClass(nextLevel);
            if (tmp != null) objectNeutralArray.add(tmp);
            objReference = nextLevel;
        }
        return objectNeutralArray;
    }

    private Object makeClass(Class c) {
        try {
            return c.newInstance();
        } catch (Exception e) {}
        return null;
    }

}
