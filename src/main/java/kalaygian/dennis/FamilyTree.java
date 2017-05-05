package kalaygian.dennis;
import java.util.ArrayList;

/**
 * Created by denniskalaygian on 5/5/17.
 */
public class FamilyTree {

    private Class originalClass;

    public FamilyTree(Class originalClass) {
        this.originalClass = originalClass;
    }

    public Class getOriginalClass() {
        return originalClass;
    }

    public void setOriginalClass(Class originalClass) {
        this.originalClass = originalClass;
    }

    public Boolean classImplementsInterface(String interfce) throws ClassNotFoundException {
        Class class1 = originalClass; //nah
        return Class.forName(interfce).isAssignableFrom(class1);
    }

    public String getClassHierarchy() throws ClassNotFoundException {

        //////Establish number of classes in the hierarchy//////
        Class class1 = originalClass; //nah

        int count = 0;

        while(class1.getSuperclass() != null){
            count += 1;
            class1 = class1.getSuperclass();
        }
        
        class1 = originalClass;

        Class[] classList = new Class[count + 1];

        classList[0] = Class.forName("java.lang.Object");

        for(int index = count; index > 0; index--){
            classList[index] = class1;
            class1 = class1.getSuperclass();
        }
        /////////////////////////////////////////////////////
        String spaces = "";
        String returnHierarchy = "";

        for(int index = 0; index < count + 1; index++){
            returnHierarchy += spaces + classList[index].getName() + "\n";
            spaces += "  ";

        }
        return returnHierarchy;

    }
}
