package wong.andrew.unitcorn;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by andrewwong on 5/5/17.
 */
public class TestDummyClass {
    @Test
    public void dummyMethod_Void_ReturnsVoid(){
        //Arrange
        DummyClass dummyClass;
        dummyClass = new DummyClass();
        boolean expectedBoolean = true;
        //Act
        boolean actualBoolean = dummyClass.dummyMethod();

        //Assert
        assertEquals(expectedBoolean, actualBoolean);
    }
}
