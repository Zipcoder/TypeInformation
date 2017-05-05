package kim.christopher.unitcorn;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

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
    public void InstantiateClassTest(){

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
    public void InstantiateClassFailTest(){

        //: When
        Object expectedObject = runner.instantiateClass(c);

        //: Then
        assertNull(expectedObject);
    }

    @Test
    public void runTestTest(){

        //: Given

        //: When

        //: Then

    }

    @Test
    public void runTestsTest(){

        //: Given

        //: When

        //: Then

    }
}
