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
        Class classObject = cl.getClass();
       if(classObject.isInstance(obj))
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
       Method[] methods =  obj.getClass().getDeclaredMethods();
       obj.getClass().getClass();

        System.out.println(obj.getClass().getDeclaredMethods().length);
       for(int i  = 0; i < methods.length; i++)
       {
           System.out.println(methods[i]);
       }

        System.out.println("size = " + methods.length);
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



}
