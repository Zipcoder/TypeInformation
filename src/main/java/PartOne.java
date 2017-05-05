import javax.naming.ldap.BasicControl;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

/**
 * Created by anthonyjones on 5/4/17.
 */
public class PartOne {

    public boolean classImplementsInterface(Object classObject, String interfaceName) {

        String testForInterface = classObject.getClass().getInterfaces()[0].getSimpleName();
        if (testForInterface.equals(interfaceName)) {
            return true;
        }
        return false;

    }

    public String listAllMember(Object classObject) {

        System.out.println("Fields");
        for (int i = 0; i < classObject.getClass().getFields().length; i++) {
            System.out.print(classObject.getClass().getFields()[i].getDeclaringClass().getSimpleName() + " ");
            System.out.println(classObject.getClass().getFields()[i]);
        }

        System.out.println("Constructors");
        for (int i = 0; i < classObject.getClass().getConstructors().length; i++) {
            System.out.print(classObject.getClass().getConstructors()[i].getDeclaringClass().getSimpleName() + " ");
            System.out.println(classObject.getClass().getConstructors()[i]);
        }

        System.out.println("Methods");
        for (int i = 0; i < classObject.getClass().getMethods().length; i++) {
            System.out.print(classObject.getClass().getMethods()[i].getDeclaringClass().getSimpleName() + " ");
            System.out.println(classObject.getClass().getMethods()[i]);


            if (classObject.getClass().getMethods()[i].toString().equals("public final native void java.lang.Object.notifyAll()")) {
                return classObject.getClass().getMethods()[classObject.getClass().getMethods().length - 1].toString();
            }
        }
        return "";
    }

    public String getClassHierarchy(Object classObject) {

        for (int i = 0; i < 3; i++) {
//            classObject.getClass().
            System.out.println(classObject.getClass().getSuperclass());
        }


        return "";
    }

}
