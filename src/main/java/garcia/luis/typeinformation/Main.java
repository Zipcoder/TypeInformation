package garcia.luis.typeinformation;

import garcia.luis.typeinformation.TypeInformation;
import sun.rmi.rmic.Constants;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.function.BiConsumer;
import java.util.function.IntConsumer;
import java.util.function.IntToDoubleFunction;

/**
 * Created by luisgarcia on 5/4/17.
 */
public class Main
{
    public static void main(String[] args)
    {
        TypeInformation myTest = new TypeInformation();
        String name = "Paco";
        Calendar date = Calendar.getInstance();
        double a = 1;

        Class cl = date.getClass();

        myTest.listAllMembers(cl);
        myTest.getClassHierarchy(cl);



    }
}
