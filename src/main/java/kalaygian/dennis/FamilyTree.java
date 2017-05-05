package kalaygian.dennis;
import java.util.ArrayList;

/**
 * Created by denniskalaygian on 5/5/17.
 */
public class FamilyTree {

    private String originalClass;

    public FamilyTree(String originalClass) {
        this.originalClass = originalClass;
    }

    public String getOriginalClass() {
        return originalClass;
    }

    public void setOriginalClass(String originalClass) {
        this.originalClass = originalClass;
    }

    public Boolean classImplementsInterface(String interfce) throws ClassNotFoundException {
        Class class1 = Class.forName(originalClass);
        return Class.forName(interfce).isAssignableFrom(class1);
    }

    public String getClassHierarchy(){
        
    }
}
