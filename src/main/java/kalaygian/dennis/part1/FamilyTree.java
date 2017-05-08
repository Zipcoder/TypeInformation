package kalaygian.dennis.part1;
import java.util.ArrayList;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;


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
        Class class1 = originalClass;
        return Class.forName(interfce).isAssignableFrom(class1);
    }

    public String getClassHierarchy() throws ClassNotFoundException {
        int count = getClassHierarchyLength();
        Class[] classList = createClassHierarchyArray(count);
        return formatClassHierarchyArray(classList);
    }

    private int getClassHierarchyLength() throws ClassNotFoundException{
        Class class1 = originalClass;
        int count = 0;
        while(class1.getSuperclass() != null){
            count += 1;
            class1 = class1.getSuperclass();
        }
        return count + 1;
    }

    private Class[] createClassHierarchyArray(int count) throws ClassNotFoundException {
        Class class1 = originalClass;
        Class[] classList = new Class[count];
        classList[0] = Class.forName("java.lang.Object");
        for(int index = count; index > 0; index--){
            classList[index - 1] = class1;
            class1 = class1.getSuperclass();
        }
        return classList;
    }

    private String formatClassHierarchyArray(Class[] classList){
        String spaces = "";
        String returnHierarchy = "";
        for(int index = 0; index < classList.length; index++){
            returnHierarchy += spaces + classList[index].getName() + "\n";
            spaces += "  ";
        }
        return returnHierarchy;
    }

    public ArrayList<Object> instantiateClassHierarchy() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        int count = getClassHierarchyLength();
        Class[] classList = createClassHierarchyArray(count);
        ArrayList<Object> returnList = new ArrayList<Object>();
        for(int index = 0; index < count; index++){

            try{
                Object element = classList[index].newInstance();
                returnList.add(element);
            } catch(Exception e) {
                Object element = null;
                returnList.add(element); 
            }
        }
        return returnList;
    }

}
