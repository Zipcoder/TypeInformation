import javax.sound.midi.SysexMessage;
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

  /*  public String listAllMembers(Object object) {

    }

    public String getClassHierarchy(Object object) {

    }

    public List instantiateClassHierarchy(Object object) {

    }*/


}
