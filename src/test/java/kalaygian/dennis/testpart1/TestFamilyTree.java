package kalaygian.dennis.testpart1;

import kalaygian.dennis.part1.FamilyTree;
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

    /*@Test
    public void testListAllMembersReturnType() throws ClassNotFoundException {
        //Given
        FamilyTree familyTree = new FamilyTree(Class.forName("java.lang.Boolean"));
        Class expectedReturnType = String.class;
        //When
        Class returnType = familyTree.listAllMembers().getClass();
        //Then
        Assert.assertEquals("Method is returning the wrong data type", expectedReturnType, returnType);
    }

    @Test
    public void testListAllMembers() throws ClassNotFoundException {
        //Given
        FamilyTree familyTree = new FamilyTree(Class.forName("java.lang.Boolean"));
        String expectedValue = "java.lang.Object" + "\n" + "  " + "java.util.AbstractCollection" + "\n" + "    " + "java.util.AbstractList" + "\n";
        //When
        String returnValue = familyTree.getClassHierarchy();
        //Then
        Assert.assertEquals("Method is not returning the right value", expectedValue, returnValue);
    }*/

    @Test
    public void testInstantiateClassHierarchyReturnType() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        //Given
        FamilyTree familyTree = new FamilyTree(Class.forName("java.util.ArrayList"));
        Class expectedReturnType = ArrayList.class;
        //When
        Class returnType = familyTree.instantiateClassHierarchy().getClass();
        //Then
        Assert.assertEquals("Method is returning the wrong data type", expectedReturnType, returnType);
    }

    @Test
    public void testInstantiateClassHierarchy() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        //Given
        FamilyTree familyTree = new FamilyTree(Class.forName("java.util.ArrayList"));
        ArrayList<Object> expectedList = new ArrayList<Object>();
        Object element1 = ArrayList.class.newInstance();
        Object element2 = null;
        Object element3 = null;
        Object element4 = Object.class.newInstance();
        expectedList.add(element4);
        expectedList.add(element3);
        expectedList.add(element2);
        expectedList.add(element1);
        ArrayList<Object> returnList;
        //When
        returnList = familyTree.instantiateClassHierarchy();
        //Then
        Assert.assertEquals("Method is not returning the right value", expectedList, returnList);
    }

}
