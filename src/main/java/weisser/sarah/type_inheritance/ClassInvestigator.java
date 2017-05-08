package weisser.sarah.type_inheritance;

import java.util.Arrays;

/**
 * Created by sarahweisser on 5/6/17.
 */
public class ClassInvestigator {

    private Class cl;
    private Object objectToInvestigate;

    public void setCl(Object objectToInvestigate) {
        this.cl = objectToInvestigate.getClass();
    }

    public void setObjectToInvestigate(Object objectToInvestigate) {
        this.objectToInvestigate = objectToInvestigate;
    }

    public Object getObjectToInvestigate() {
        return objectToInvestigate;
    }

    public ClassInvestigator(Object objectToInvestigate) {
        this.objectToInvestigate = objectToInvestigate;
        setCl(objectToInvestigate);
    }

    public String[] getObjectInterfaces() {

        String[] objectInterfaces = new String[cl.getInterfaces().length];
        for(int i = 0; i < objectInterfaces.length; i++) {
            objectInterfaces[i] = cl.getInterfaces()[i].toString();
        }
        return objectInterfaces;
    }


    public boolean classImplementsInterface(Object objectToInvestigate, String interfaceName) {

        return Arrays.asList(getObjectInterfaces()).contains(interfaceName);

    }

    public boolean classImplementsInterface(Class cl, String interfaceName) {

        return Arrays.asList(getObjectInterfaces()).contains(interfaceName);

    }
}
