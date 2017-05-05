package kalaygian.dennis;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;


public class TestFamilyTree{

    @Test
    public void testClassImplementsInterfaceReturnType() throws ClassNotFoundException {
        //Given
        FamilyTree familyTree = new FamilyTree(Class.forName("java.util.ArrayList"));
        Class expectedReturnType = Boolean.class;
        //When
        Class returnType = familyTree.classImplementsInterface("java.util.List").getClass();
        //Then
        Assert.assertEquals("Method is returning the wrong data type", expectedReturnType, returnType);
    }

    @Test
    public void testClassImplementsInterface() throws ClassNotFoundException {
        //Given
        FamilyTree familyTree = new FamilyTree(Class.forName("java.util.ArrayList"));
        boolean expectedOutcome = true;
        //When
        Boolean methodOutcome = familyTree.classImplementsInterface("java.util.List");
        //Then
        Assert.assertEquals("Method is returning the wrong boolean", expectedOutcome, methodOutcome);
    }

    @Test
    public void testGetClassHierarchyReturnType() throws ClassNotFoundException {
        //Given
        FamilyTree familyTree = new FamilyTree(Class.forName("java.util.AbstractList"));
        Class expectedReturnType = String.class;
        //When
        Class returnType = familyTree.getClassHierarchy().getClass();
        //Then
        Assert.assertEquals("Method is returning the wrong data type", expectedReturnType, returnType);
    }

    @Test
    public void testGetClassHierarchy() throws ClassNotFoundException {
        //Given
        FamilyTree familyTree = new FamilyTree(Class.forName("java.util.AbstractList"));
        String expectedValue = "java.lang.Object" + "\n" + "  " + "java.util.AbstractCollection" + "\n" + "    " + "java.util.AbstractList" + "\n";
        //When
        String returnValue = familyTree.getClassHierarchy();
        //Then
        Assert.assertEquals("Method is not returning the right value", expectedValue, returnValue);
    }
}
