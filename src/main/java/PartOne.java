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


    public String listAllMember(Object o) {


        return "";
    }

}
