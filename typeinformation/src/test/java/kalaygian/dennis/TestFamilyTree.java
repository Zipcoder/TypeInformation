package java.kalaygian.dennis;

import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;


public class TestFamilyTree{

    @Test
    public void testClassImplementsInterfaceReturnType(){
        //Given
        FamilyTree familyTree = new FamilyTree(ArrayList);
        Class expectedReturnType = Boolean.class;
        //When
        Class returnType = (familyTree.classImplementsInterface(List)).class;
        //Then
        Assert.assertEquals("Method is returning the wrong data type", expectedReturnType, returnType);
    }

    @Test
    public void testClassImplementsInterface(){
        //Given
        FamilyTree familyTree = new FamilyTree(ArrayList);
        boolean expectedOutcome = true;
        //When
        boolean methodOutcome = familyTree.classImplementsInterface(List);
        //Then
        Assert.assertEquals("Method is returning the wrong boolean", expectedOutcome, methodOutcome);
    }
}
