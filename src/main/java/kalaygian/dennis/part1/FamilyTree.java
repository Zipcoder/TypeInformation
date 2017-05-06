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
        int count = getClassHierarchyLength(); // Count the number of classes in the hierarchy
        Class[] classList = createClassHierarchyArray(count); // For every class in the hierarchy, add it to the class array
        ArrayList<Object> returnList = new ArrayList<Object>(); // Instantiate a list of objects to be returned
        for(int index = 0; index < count; index++){ // For every element in the class array
            // The following line is throwing an IllegalAccessException
            try{ // If the class can be instantiated (ie it is not abstract)
                Object element = classList[index].newInstance(); // Create a new instance of the class and store in the element variable
                returnList.add(element); // Add this variable to the list of objects to be returned
            } catch(Exception e) { // If the class cannot be instantiated (ie it is abstract)
                Object element = null;
                returnList.add(element); // Add a value of null to the list
            }
        }
        return returnList;
    }

}
