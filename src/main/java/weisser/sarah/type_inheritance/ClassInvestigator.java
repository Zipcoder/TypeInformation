package weisser.sarah.type_inheritance;

import java.util.Arrays;

/**
 * Created by sarahweisser on 5/6/17.
 */
public class ClassInvestigator {

    private Object objectToInvestigate;

    public void setObjectToInvestigate(Object objectToInvestigate) {
        this.objectToInvestigate = objectToInvestigate;
    }

    public Object getObjectToInvestigate() {
        return objectToInvestigate;
    }

    public ClassInvestigator(Object objectToInvestigate) {
        this.objectToInvestigate = objectToInvestigate;
    }

    public String[] getObjectInterfaces() {

        String[] objectInterfaces = new String[objectToInvestigate.getClass().getInterfaces().length];
        for(int i = 0; i < objectInterfaces.getClass().getInterfaces().length; i++) {
            objectInterfaces[i] = objectToInvestigate.getClass().getInterfaces()[i].toString();
        }
        return objectInterfaces;
    }


    public boolean classImplementsInterface(Object objectToInvestigate, String interfaceName) {

        return Arrays.asList(getObjectInterfaces()).contains(interfaceName);

    }
}
