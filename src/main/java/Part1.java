import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by aurorabanuelos on 5/4/17.
 */
public class Part1 {

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

}