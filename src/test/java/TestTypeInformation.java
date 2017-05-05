
import garcia.luis.TypeInformation;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by luisgarcia on 5/4/17.
 */
public class TestTypeInformation
{
    TypeInformation test = new TypeInformation();
    String strObj = "hello";
    Double dbl = 3.2;
    Class cl = dbl.getClass();
    ArrayList<String> myList;


    @Test
    public void testImplementsInterface()
    {
        //given
        boolean expected = false;

        //when
        boolean actual =  test.classImplementsInterface(strObj, cl);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testListAllMembers()
    {
        //when
        Method[] methods =  strObj.getClass().getDeclaredMethods();
        int expected = 77;

        //when
        int actual = strObj.getClass().getDeclaredMethods().length;

        //then
        Assert.assertEquals(expected, actual, 0);

    }

    @Test
    public void testHierarchy()
    {
        //given
        myList = test.getSuperClass(cl);
        String expected = "java.lang.Object";

        //when
        String actual = myList.get(1);

        //then
        Assert.assertEquals(expected, actual);


    }

}
