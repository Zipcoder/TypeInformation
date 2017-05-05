package garcia.luis.typeinformation;

import garcia.luis.typeinformation.TypeInformation;
import sun.rmi.rmic.Constants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 * Created by luisgarcia on 5/4/17.
 */
public class Main
{
    public static void main(String[] args)
    {
        TypeInformation myTest = new TypeInformation();
        Calendar date = Calendar.getInstance();

        Class cl = date.getClass();

        myTest.listAllMembers(cl);
        myTest.getClassHierarchy(cl);

        System.out.println(myTest.instantiateClassHierarchy(cl));

    }
}
