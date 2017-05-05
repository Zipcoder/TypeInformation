package wong.andrew.unitcorn;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by andrewwong on 5/5/17.
 */
public class TestUnitCornTestRunner {
//    @Before
//    public void initializeUnitCorn(){
//        UnitCornTestRunner unitCorn = new UnitCornTestRunner();
//    }
    @Test
    public void runTest_TestingPartOneListAllMembers_ResultReturned(){
        //Arrange
        UnitCornTestRunner unitCorn = new UnitCornTestRunner();
        Result result;

        Class c;
        String methodName = "";

        //Act
        result = unitCorn.runTest(c, methodName);

        //Assert
        assertNotNull(result);


    }
}
