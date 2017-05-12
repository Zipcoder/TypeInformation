import org.junit.Test;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by andrewwong on 5/4/17.
 */
public class TestPartOne {
    @Test
    public void classImplementsInterface_ClassIsDimensionInterfaceIsSerializable_DimensionImplementsSerializableIsTrue() {
        //Arrange
        Class aClass;
        aClass = Dimension.class;
        PartOne partOne = new PartOne();
        String interfaceName = Serializable.class.getSimpleName();

        //Act
        boolean isImplemented = partOne.classImplementsInterface(aClass, interfaceName);

        //Assert
        assertTrue(isImplemented);
    }
    @Test
    public void listAllMembers_ObjectHasMembers_ListOfMembersIsReturned(){
        //Arrange
        PartOne partOne = new PartOne();
        ExampleClass o = new ExampleClass();
        String expectedList = "Fields:\nExampleClass private field1\nExampleClass private field2\nExampleClass private field3\nExampleClass private field4\n"+
                "Methods:\nExampleClass public addFields\nObject public final wait\nObject public final native wait\nObject public final wait\nObject public equals\nObject public toString\nObject public native hashCode\nObject public final native getClass\nObject public final native notify\nObject public final native notifyAll\n"+
                "Constructors:\nExampleClass public ExampleClass\nExampleClass public ExampleClass\nExampleClass public ExampleClass\n";

        //Act
        String actualList = partOne.listAllMembers(o);

        //Assert
        assertEquals(expectedList,actualList);
    }
    @Test
    public void getClassHierarchy_ClassIsInteger_HierarchyWithObjectAndNumberIsReturned(){
        //Arrange
        String expectedHierarchy = "class java.lang.Object\n  class java.lang.Number\n    class java.lang.Integer\n";
        PartOne partOne = new PartOne();
        //Act
        String actualHierarchy = partOne.getClassHierarchy(new Integer(0));

        //Assert
        assertEquals(expectedHierarchy.trim(), actualHierarchy.trim());
    }
    @Test
    public void instantiateClassHierarchy_ClassIsExampleClass_returnsListOfInstancesOfAllConcreteClasses(){
        //Arrange
        PartOne partOne = new PartOne();
        Class exampleClassClass = new ExampleClass().getClass();
        Class objectClass = new Object().getClass();
        ArrayList<Class> expectedClassesOfInstances = new ArrayList<>();
        expectedClassesOfInstances.add(exampleClassClass);
        expectedClassesOfInstances.add(objectClass);

        //Act
        ArrayList<Object> actualInstances = partOne.instantiateClassHierarchy(new ExampleClass());
        ArrayList<Class> actualClassesOfInstances = new ArrayList<>();
        for(Object instance: actualInstances){
            actualClassesOfInstances.add(instance.getClass());
        }

        //Assert
        assertTrue(expectedClassesOfInstances.equals(actualClassesOfInstances));
        //assert that the class of the each instance in the instances array is different
    }

}
