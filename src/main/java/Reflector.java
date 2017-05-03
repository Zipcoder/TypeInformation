import javax.sound.midi.SysexMessage;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by cameronsima on 5/2/17.
 */
public class Reflector {

    public boolean classImplementsInterface(Object object, String interfaceName) {

        try {
            Class intface = Class.forName(interfaceName);

            return intface.isAssignableFrom(object.getClass());
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean classImplementsInterface(String objectName, String interfaceName) {

        try {
            Class object = Class.forName(objectName);
            Class intface = Class.forName(interfaceName);
            return intface.isAssignableFrom(object);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean classImplementsInterface(Class clASS, String interfaceName) {

        try {
            Class intface = Class.forName(interfaceName);
            return intface.isAssignableFrom(clASS);
        } catch (ClassNotFoundException e){
            System.out.println(e);
            return false;
        }
    }

    public String listAllMembers(Object object) {

        ArrayList<Class> classes = getClassArray(object);
        StringBuilder sb = new StringBuilder();

        for (Class cls : classes) {
            System.out.println(cls);
            sb.append(getClassMembers(cls));
        }
        return sb.toString();
    }

    public String getClassMembers(Class cls) {
        StringBuilder sb = new StringBuilder();

        for (Field field : cls.getDeclaredFields()) {
            sb.append(field + "\n");
        }
        for (Constructor constructor : cls.getConstructors()) {
            sb.append(constructor + "\n");
        }

        for (Method method : cls.getDeclaredMethods()) {
            sb.append(method + "\n");
        }

        String result = sb.toString();
        return result;
    }

    private ArrayList getClassArray(Object object) {

        Class cls = object.getClass();
        ArrayList<Class> classes = new ArrayList<>();

        while(cls != null) {
            classes.add(cls);
            cls = cls.getSuperclass();
        }
        Collections.reverse(classes);
        return classes;
    }

    public String getClassHierarchy(Object object) {

        ArrayList<Class> classes = getClassArray(object);
        return buildHierarchyString(classes);
    }

    private String buildHierarchyString(ArrayList classes) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i<classes.size(); i++) {
            String tabs = "";

            for (int j = 0; j<i; j++) {
                tabs += "\t";
            }
            sb.append(tabs + classes.get(i) + "\n");
        }
        return sb.toString();
    }


    public List instantiateClassHierarchy(Object object) {

        ArrayList<Class> classes = getClassArray(object);
        ArrayList<Object> instances = new ArrayList<>();

        for (Class cls : classes) {
            try {
                instances.add(cls.newInstance());
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(cls + " can't be instantiated.");
            }
        }
        return instances;
    }
}
