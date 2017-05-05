package wong.andrew.unitcorn;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by andrewwong on 5/5/17.
 */
public class TestDummyClass {
    @Test
    public void dummyMethodOne_True_ReturnsTrue(){
        //Arrange
        DummyClass dummyClass;
        dummyClass = new DummyClass();
        //Act
        boolean actualBoolean = dummyClass.dummyMethodOne();

        //Assert
        assertTrue(actualBoolean);
    }
    @Test
    public void dummyMethodTwo_Zero_ReturnsZero(){
        //Arrange
        DummyClass dummyClass;
        dummyClass = new DummyClass();
        int expectedInt = 0;
        //Act
        int actualInt = dummyClass.dummyMethodTwo();
        //Assert
        assertEquals(expectedInt, actualInt);
    }
}
