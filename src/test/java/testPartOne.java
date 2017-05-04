import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Currency;

/**
 * Created by anthonyjones on 5/4/17.
 */
public class testPartOne {


    @Test
    public void testClassImplementsInterface() {

        //given
        Class className = Currency.class;
        String interfaceName = Serializable.class.getSimpleName();
        PartOne testingMethods = new PartOne();

        //when
        boolean actualAnswer = testingMethods.classImplementsInterface(className, interfaceName);

        //then
        Assert.assertEquals(true, actualAnswer);

    }

    @Test
    public void testListAllMember() {

        Class className = Currency.class;
        ArrayList<?>  listOfObjectFields = new ArrayList<Object>();
        ArrayList<?>  listOfObjectMethod = new ArrayList<Object>();
        ArrayList<?>  listOfObjectConstructors = new ArrayList<Object>();

        className.getSuperclass().getFields();
        className.getModifiers();
        className.getConstructors();

        className.getFields();


    }


}
