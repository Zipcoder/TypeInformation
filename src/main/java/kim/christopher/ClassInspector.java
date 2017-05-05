package kim.christopher;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.lang.Class;

public class ClassInspector {


    //Take two arguments: 1) a class, specified by an object, Class object, or class name, and 2) an interface name.
    // Return true if the specified class implements the specified interface
    public boolean classImplementsInterface(Class c, String s){
        Class[] interfaceArray = c.getInterfaces();
        for(Class i: interfaceArray){
            if (i.getSimpleName().equals(s)) return true;
        }
        return false;
    }

    //Take an object and list all declared members (Fields, Constructors, and Methods) of its class, as well as those of each superclass, all the way to Object.
    //This method should return a string containing each declared member listed on a separate line as follows:
    //The member name, preceded with the name of the declaring class, and any modifiers (static, private etc.)
    //Within each class, members should be listed in the order: Fields, Constructors, Methods
    //Each group of members (fields, constructors, or methods) should be listed alphabetically
    //The first line should start with the members declared by the given object type; the last line should be the last method defined by Object
    public String listAllMembers(Object object){
        System.out.println("Hello");
        StringBuilder sb = new StringBuilder();
        sb.append("Fields:\n" + listFields(object) + "\n");
        sb.append("Constructors\n" + listConstructors(object) + "\n");
        sb.append("Methods\n" + listMethods(object));
        return sb.toString();
    }

    public String listFields(Object object){
        StringBuilder sb = new StringBuilder();
        Class classOfObject = object.getClass();
        Field[] fields = classOfObject.getFields();
        for(Field f: fields){
            sb.append(f.getDeclaringClass().getSimpleName()+ ": " + f.toString() + "\n");
        }
        return sb.toString();
    }

    public String listConstructors(Object object){
        StringBuilder sb = new StringBuilder();
        Class classOfObject = object.getClass();
        Constructor[] constructors = classOfObject.getConstructors();
        for(Constructor c: constructors){
            sb.append(c.getDeclaringClass().getSimpleName() + ": "  + c.toString() + "\n");
        }
        return sb.toString();
    }

    public String listMethods(Object object){
        StringBuilder sb = new StringBuilder();
        Class classOfObject = object.getClass();
        Method[] methods = object.getClass().getMethods();
        for(Method m: methods){
            sb.append(m.getDeclaringClass().getSimpleName() + ": " + m.toString() + "\n");
        }
        return sb.toString();
    }

    // Take an object and produce an indented class hierarchy with one class per line.
    // Each line should be indented two spaces more than the previous one.
    // The first line should be java.lang.Object
    public String getClassHierarchy(Object obj){
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<String>();
        Class classOfObject = obj.getClass();
        boolean flag = true;
        list.add(classOfObject.getSimpleName());
        while(flag){
            list.add(classOfObject.getSuperclass().getSimpleName());
            classOfObject = classOfObject.getSuperclass();
            if(classOfObject.getSimpleName().equals("Object")) flag = false;
        }
        //counter for number of spaces to add at the beginning of the line
        int count = 1;

        for(int i = list.size() - 1; i >= 0; i--){
            sb.append(list.get(i) + "\n");
            //loop that adds two spaces each time it runs
            for(int j = 0; j < count; j++){
                sb.append("  ");
            }
            count++;
        }

        return sb.toString();
    }


    //take an object and return a List containing instances of every concrete class in its hierarchy.
    // Handle classes without a no-argument constructor gracefully (your program should not crash, but may not be able to instantiate these classes).
    // Note: Your test should confirm that each list item is an instance of a different class.
    public ArrayList<Object> instantiateClassHierarchy(Object obj){

//        Class c = obj.getClass();
//        boolean flag = true;
//        ArrayList<Object>
//        while(flag){
//
//        }
    }
}
