package io.github.aaronclong.TypeInformation.partOne;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by aaronlong on 5/2/17.
 */
public class ClassExplorerTest {

    private Class theInterface;
    private ClassExplorer checkingClass;
    private Class classInstance;

    @Before
    public void setUp() {
        try {
            theInterface = Class.forName("java.util.List");
            checkingClass = new ClassExplorer();
            classInstance = Class.forName("java.util.ArrayList");
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
}
