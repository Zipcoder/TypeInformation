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
        String interfaceName = "interface java.lang.Comparable";

        //When:
        boolean actualOutput = app.classImplementsInterface(bigDecimal, interfaceName);

        //Then:
        Assert.assertTrue(actualOutput);
    }

    @Test
    public void testThatClassImplementsInterfaceIfInputIsString() {

        try {
            //Given:
            classImplementsInterfaceApp app = new classImplementsInterfaceApp();
            String name = "java.math.BigDecimal";
            Class bigDecimalClass = Class.forName(name);
            String interfaceName = "interface java.lang.Comparable";

            //When:
            boolean actualOutput = app.classImplementsInterface(name, interfaceName);

            //Then:
            Assert.assertTrue(actualOutput);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found.");
        }
    }

    @Test
    public void testThatClassImplementsInterfaceIfInputIsClassObject() {

            //Given:
            classImplementsInterfaceApp app = new classImplementsInterfaceApp();
            BigDecimal bigDecimal = new BigDecimal(100);
            Class objectName = bigDecimal.getClass();
            String interfaceName = "interface java.lang.Comparable";

            //When:
            boolean actualOutput = app.classImplementsInterface(objectName, interfaceName);

            //Then:
            Assert.assertTrue(actualOutput);

    }

}
