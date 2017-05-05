package io.github.aaronclong.TypeInformation.partOne;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import com.google.common.io.CharStreams;


import java.lang.reflect.*;
import java.util.List;

import java.util.ArrayList;

/**
 * Created by aaronlong on 5/2/17.
 */
public class ClassExplorerTest {

    private Class theInterface;
    private ClassExplorer checkingClass;
    private Class classInstance;
    private Class classInteger;

    @Before
    public void setUp() {
        try {
            theInterface = Class.forName("java.util.List");
            checkingClass = new ClassExplorer();
            classInstance = Class.forName("java.util.ArrayList");
            classInteger = Class.forName("java.lang.Integer");
        } catch(ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    @Test
    public void testClassImplementsInterface() {
        Assert.assertTrue("Checking Implementation with String passed",
                checkingClass.classImplementsInterface("java.util.ArrayList", theInterface));
        Object arrayListObject = new ArrayList<Integer>();
        Assert.assertTrue("Checking Implementation with Object passed",
                checkingClass.classImplementsInterface(arrayListObject, theInterface));
        Assert.assertTrue("Checking Implementation with Class object passed",
                checkingClass.classImplementsInterface(classInstance, theInterface));
    }

    @Test
    public void testsListAllMembers() {

        try {
            String url = getClass().getClassLoader().getResource("IntegerTestData.txt").getFile();
            FileReader reader = new FileReader(url);
            String result = CharStreams.toString(reader);
            Assert.assertTrue("Confirming similar method output",
                    result.equals(checkingClass.listAllMembers(new Integer(7))));
        } catch(IOException e) { System.out.println(e); }
    }

    @Test
    public void testClassHierarchy() {
        String integerClassHierarchy = "class java.lang.Object\n" +
                    " class java.lang.Number\n" +
                    "  class java.lang.Integer\n";
        Assert.assertEquals("Confirming class Hierarchy",
                    integerClassHierarchy, checkingClass.getClassHierarchy(new Integer(7)));
    }

    @Test
    public void testInstantiateClassHierarchy() {
        List istantiatedClass = checkingClass.instantiateClassHierarchy(new Integer(9));
        Assert.assertEquals("Confirming quantity of instantiated classes", 1, istantiatedClass.size());
    }
}
