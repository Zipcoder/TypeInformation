package garcia.luis;

import javax.sound.midi.Soundbank;
import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * Created by luisgarcia on 5/4/17.
 */
public class TypeInformation<T>
{

    public boolean classImplementsInterface(Object obj, String theInterface)
    {
        Class classObject = obj.getClass();
        Class [] interfaces = classObject.getInterfaces();
        for(int i = 0; i < interfaces.length; i++)
        {
            if(theInterface.equals(interfaces[i].getName()))
            {
                return true;
            }
        }
        return false;
    }

    public boolean classImplementsInterface(Class obj, String theInterface)
    {
        Class [] interfaces = obj.getInterfaces();
        for(int i = 0; i < interfaces.length; i++)
        {
            if(theInterface.equals(interfaces[i].getName()))
            {
                return true;
            }
        }
        return false;
    }

    public boolean classImplementsInterface(String obj, String theInterface) throws ClassNotFoundException
    {
        Class cl = Class.forName(obj);
        Class [] interfaces = cl.getInterfaces();
        for(int i = 0; i < interfaces.length; i++)
        {
            if(theInterface.equals(interfaces[i].getName()))
            {
                return true;
            }
        }
        return false;

    }

    public void listAllMembers(Object obj)
    {
        Class cl = obj.getClass();
        ArrayList myList = getSuperClass(obj);
        System.out.println(myList.size());
        for(int i=0; i<myList.size();i++)
        {
            System.out.println("Class: " + myList.get(i));
            printAllMembers(obj);
        }


    }

    public void getClassHierarchy(Object obj)
    {
        String tab ="";
        System.out.println("Class Hierarchy");
        ArrayList <?> mySuperList = getSuperClass(obj.getClass());

        for(int i = mySuperList.size()-1;i >= 0; i--)
        {
            System.out.println(tab + mySuperList.get(i));
            tab= tab + "    ";

        }



    }

    public ArrayList <String> getSuperClass(Object obj)
    {
        ArrayList<String> superClassList = new ArrayList<String>();
        String superClass = Object.class.getName();
        int i =0;


        do{
                superClassList.add(obj.getClass().getSuperclass().getName());
                obj = obj.getClass().getSuperclass();

        }
        while (!superClass.equals(superClassList.get(i++)));

        return superClassList;

    }

    public ArrayList instantiateClassHierarchy(Object obj)
    {
        ArrayList myList = getSuperClass(obj);
        ArrayList<Object> instance = new ArrayList<Object>();
        for(int i = 0; i < myList.size(); i++)
        {
            if(obj.getClass().isInstance(myList.get(i)))
            {
                instance.add(obj);
            }
        }
        return instance;
    }

    public void printAllMembers(Object obj)
    {
        Constructor[] constructors = obj.getClass().getDeclaredConstructors();
        Field [] fields =  obj.getClass().getDeclaredFields();
        Method [] methods = obj.getClass().getDeclaredMethods();

        System.out.println("Constructors");
        for(int i  = 0; i < constructors.length; i++)
        {
            System.out.println(constructors[i]);
        }
        System.out.println("Fields");
        for(int i  = 0; i < fields.length; i++)
        {
            System.out.println(fields[i]);
        }
        System.out.println("Methods");
        for(int i  = 0; i < methods.length; i++)
        {
            System.out.println(methods[i]);
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        TypeInformation test = new TypeInformation();
        String myString = "Paco";
        Double myDouble = 2.33;
        ArrayList myList = test.instantiateClassHierarchy(myString);
        System.out.println(myList);


    }


}
