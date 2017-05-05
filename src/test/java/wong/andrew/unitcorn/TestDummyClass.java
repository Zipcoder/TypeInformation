package wong.andrew.unitcorn;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by andrewwong on 5/5/17.
 */
public class TestDummyClass {
    @Test
    public void dummyMethod_True_ReturnsTrue(){
        //Arrange
        DummyClass dummyClass;
        dummyClass = new DummyClass();
        //Act
        boolean actualBoolean = dummyClass.dummyMethod();

        //Assert
        assertTrue(actualBoolean);
    }
}
