package garcia.luis.typeinformation;

import org.junit.Test;
import org.junit.Assert;
import java.lang.reflect.*;
import java.util.ArrayList;

/**
 * Created by luisgarcia on 5/4/17.
 */
public class TypeInformation<T>
{
    public  TypeInformation(){}

    public boolean classImplementsInterface(Object obj, Class<T> cl)
    {
        Class classObject = obj.getClass();
       if(classObject.isInstance(obj))
       {
           return true;
       }
       else
       {
           return false;
       }
    }

    public boolean classImplementsInterface(Class obj, Class<T> cl)
    {

        if(cl.isInstance(obj))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean classImplementsInterface(String obj, Class<T> cl)
    {
        Class classObject = obj.getClass();
        if(cl.isInstance(obj))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void listAllMembers(Class<T> obj)
    {
        Class cl = obj.getClass();
        Constructor[] constructors = cl.getDeclaredConstructors();
        Field [] fields = cl.getDeclaredFields();
        Method [] methods = cl.getDeclaredMethods();

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

    public void getClassHierarchy(Class<T> obj)
    {
        String tab ="";
        System.out.println("Class Hierarchy");
        ArrayList <?> mySuperList = getSuperClass(obj);

        for(int i = mySuperList.size()-1;i >= 0; i--)
        {
            System.out.println(tab + mySuperList.get(i));
            tab= tab + "    ";

        }



    }

    public ArrayList <String> getSuperClass(Class<?> obj)
    {
        ArrayList<String> superClassList = new ArrayList<String>();
        String superClass = Object.class.getName();
        int i =0;


        do{
                superClassList.add(obj.getSuperclass().getName());
                obj = obj.getSuperclass();

        }
        while (!superClass.equals(superClassList.get(i++)));

        return superClassList;

    }

    public ArrayList<?> instantiateClassHierarchy(Class<?> obj)
    {
        ArrayList <?> myList = getSuperClass(obj);
        ArrayList<Object> instance = new ArrayList<Object>();
        for(int i = 0; i < myList.size(); i++)
        {
            if(obj.getClass().isInstance(myList.get(i)))
            {
                instance.add(myList.get(i));
            }
        }
        return instance;
    }





}
