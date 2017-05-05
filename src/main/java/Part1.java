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
}