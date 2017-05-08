import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by aurorabanuelos on 5/4/17.
 */
public class Part1{

    boolean x;


    public boolean classImplementsInterface(Class cls, Class inter) {

        Class[] interfaceList = cls.getInterfaces();

        for (Class e : interfaceList)
            if (e.equals(inter)) {
                x = true;
            } else {
                x = false;
            }

        return x;


    }

    public String getClassHierarchy(Class cls) {

        ArrayList supercls = new ArrayList();

        Class superClass = cls.getSuperclass();
        while (superClass != null) {
            supercls.add(superClass.getName());
            superClass = superClass.getSuperclass();
        }

        Collections.reverse(supercls);

        for(Object e: supercls) {
            System.out.printf("\n  %s", e);
        }

        return supercls.toString();

    }

    public String listAllMembers(Class cls){
        Constructor [] ctors = cls.getDeclaredConstructors();
        Field[] flds = cls.getDeclaredFields();
        Method[] mthds = cls.getDeclaredMethods();

        ArrayList members = new ArrayList();

        for (Field f: flds){
            members.add(cls + " " + Modifier.toString(f.getModifiers()) + " Field: " + f.getName() );
        }

        for (Constructor c: ctors){
            members.add(cls + " " + Modifier.toString(c.getModifiers()) + " Constructor: " + c.getName() );
        }

        for (Method m: mthds){
            members.add(cls + " " + Modifier.toString(m.getModifiers()) + " Method: " + m.getName() );
        }

        for(Object e: members) {
            System.out.println(e);
        }

        return members.toString();

    }
}