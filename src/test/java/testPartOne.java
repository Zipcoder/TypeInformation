import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
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
        //given
        String stringThatShouldAppear = "public final native void java.lang.Object.notifyAll()";
        Object objectName = new Button();
        PartOne testingMemberExistence = new PartOne();
        //when
        String actualAnswer = testingMemberExistence.listAllMember(objectName);
        //then
        Assert.assertEquals(stringThatShouldAppear, actualAnswer);


    }

    @Test
    public void testGetClassHierarchy() {
        //given
        Object objectName = new Button();
        String expectedString = "    Button";
        PartOne testing = new PartOne();
        //when
        String actualAnswer = testing.getClassHierarchy(objectName);

        //then
        Assert.assertEquals(expectedString,actualAnswer);


    }


}
