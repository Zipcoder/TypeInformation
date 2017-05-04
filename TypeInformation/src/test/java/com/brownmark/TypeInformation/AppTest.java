package com.brownmark.TypeInformation;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.lang.reflect.*;
public class AppTest {

    @Test
    public void testThatClassImplementsInterfaceIfInputIsObject() {

        //Given:
        classImplementsInterfaceApp app = new classImplementsInterfaceApp();
        BigDecimal bigDecimal = new BigDecimal(10);
        Class bigDecimalClass = bigDecimal.getClass();
        String interfaceName = "interface java.lang.Comparable";

        //When:
        boolean actualOutput = app.classImplementsInterface(bigDecimal, interfaceName);

        //Then:
        Assert.assertTrue(actualOutput);
    }

    @Test
    public void testThatClassImplementsInterfaceIfInputIsString() {

        //Given:
        classImplementsInterfaceApp app = new classImplementsInterfaceApp();
        BigDecimal bigDecimal = new BigDecimal(10);
        Class bigDecimalClass = bigDecimal.getClass();
        String interfaceName = "interface java.lang.Comparable";

        //When:
        boolean actualOutput = app.classImplementsInterface(bigDecimal, interfaceName);

        //Then:
        Assert.assertTrue(actualOutput);

    }

}
