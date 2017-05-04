import java.awt.*;
import java.io.Serializable;

/**
 * Created by andrewwong on 5/4/17.
 */
public class PartOne {
    public boolean classImplementsInterface(Class<Dimension> dimension, String interfaceName){
        boolean isImplemented = false;
        Object[] interfaces = dimension.getInterfaces();
        for(int i = 0; i < interfaces.length; i++){
            if (interfaces[i].toString().equalsIgnoreCase(interfaceName)){
                isImplemented = true;
                break;
            }
        }
        return isImplemented;
    }

}
