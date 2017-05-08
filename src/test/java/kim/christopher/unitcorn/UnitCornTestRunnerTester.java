package kim.christopher.unitcorn;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Method;

public class UnitCornTestRunnerTester {

    Class c;
    String methodName;
    UnitCornTestRunner runner;

    @Before
    public void initialize() {
        c = Double.class;
        methodName = "isNaN";
        runner = new UnitCornTestRunner();
    }

    @Test
    public void getMethodTest(){

        //: When
        Method result = runner.getMethod(c, methodName);
        String expectedValue = "isNaN";
        String actualValue = result.getName();

        //: Then
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void instantiateClassTest(){

        //: Given
        c = String.class;

        //: When
        Object obj = runner.instantiateClass(c);
        String expectedValue = "String";
        String actualValue = obj.getClass().getSimpleName();

        //: Then
        assertEquals(expectedValue, actualValue);

    }

    @Test
    public void instantiateClassFailTest(){

        //: When
        Object expectedObject = runner.instantiateClass(c);

        //: Then
        assertNull(expectedObject);
    }

    @Test
    public void runTestPassTest(){
        //: When
        Result result = runner.runTest(UnitCornTestRunnerTester.class, "");
        boolean actualPass = result.isSuccessful();
        String actualMessage = result.getMessage();
        String expectedMessage = "PASS";

        //: Then
        assertTrue(actualPass);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void runTestFailTest(){
        //: When
        Result result = runner.runTest(UnitCornTestRunnerTester.class, "public void UnitCornTestRunnerTester.instantiateClassFailTest()");
        boolean actualPass = result.isSuccessful();
        String actualMessage = result.getMessage();
        String expectedMessage = "FAIL";

        //: Then
        assertTrue(!actualPass);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void runTestsTest(){

        //: Given

        //: When

        //: Then

    }
}
