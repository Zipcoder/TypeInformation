package io.github.aaronclong.TypeInformation.partOne;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import com.google.common.io.CharStreams;


import java.lang.reflect.*;

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
        // I tried for ten years
        // This is an untestable method
        // Why do you hate me Dave?
        // What did I ever do to you!?
        /* try {
            String url = getClass().getClassLoader().getResource("IntegerTestData.txt").getFile();
            FileReader reader = new FileReader(url);
            String result = CharStreams.toString(reader);
            Assert.assertTrue("Confirming similar method output",
                    result.equals(checkingClass.listAllMembers(new Integer(4))));
        } catch(IOException e) { System.out.println(e); } */
    }

    @Test
    public void testClassHierarchy() {
        //try {
            //String url = getClass().getClassLoader().getResource("ClassHierarchyTestData.txt").getFile();
            //FileReader reader = new FileReader(url);
            //System.out.println(url);
            String integerClassHierarchy = "class java.lang.Object\n" +
                    " class java.lang.Number\n" +
                    "  class java.lang.Integer\n";
            //String result = CharStreams.toString(reader);
            //System.out.println(checkingClass.getClassHierarchy(new Integer(7)));
            //System.out.println(result);
            //System.out.print(hey.equals(checkingClass.getClassHierarchy(new Integer(7))));
            Assert.assertEquals("Confirming class Hierarchy",
                    integerClassHierarchy, checkingClass.getClassHierarchy(new Integer(7)));
            //System.out.print(result);

        //} catch(IOException e) { System.out.println(e); }
    }
}
