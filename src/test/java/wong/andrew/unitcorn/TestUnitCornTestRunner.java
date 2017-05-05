package wong.andrew.unitcorn;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

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

        Class c = TestDummyClass.class;
        String methodName = "dummyMethod_True_ReturnsTrue";

        //Act
        result = unitCorn.runTest(c, methodName);

        //Assert
        assertNotNull(result);
    }
    @Test
    public void getMethodFromClass_MethodExists_MethodReturned(){
        //Arrange
        UnitCornTestRunner unitCorn = new UnitCornTestRunner();
        Class c = TestDummyClass.class;
        String methodName = "dummyMethod_True_ReturnsTrue";
        String expectedMethodName = "dummyMethod_True_ReturnsTrue";
        //Act
        Method actualMethod = unitCorn.getMethod(c, methodName);
        String actualMethodName = actualMethod.getName();
        //Assert
        assertEquals(expectedMethodName, actualMethodName);
    }
}
