import org.junit.Test;

import java.awt.*;
import java.io.Serializable;

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
        Class anObject;
        anObject = ExampleClass.class;
        String expectedList = "private field1\nprivate field2\nprivate field3\nprivate field4\npublic addFields\npublic ExampleClass\npublic ExampleClass\npublic ExampleClass\n";

        //Act
        String actualList = partOne.listAllMembers(anObject);

        //Assert
        assertEquals(expectedList,actualList);
    }
}
