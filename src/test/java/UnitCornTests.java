import jdk.management.cmm.SystemResourcePressureMXBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sima.cameron.unitcorn.Result;
import sima.cameron.unitcorn.UnitCornTestRunner;

/**
 * Created by cameronsima on 5/4/17.
 */
public class UnitCornTests {

    private Class cls;
    private Class testTestsClass;

    @Before
    public void setup() {

        try {
            cls = Class.forName("ReflectorTest");
           // System.out.println("CLass: " + cls.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }

        try {
            testTestsClass = Class.forName("UnitCornTestRunnerTestTests");
        } catch (ClassNotFoundException e) {
            System.out.println("Test Class not found");
        }
    }

    @Test
    public void testRunTest_withFailingTest() {

        UnitCornTestRunner utr = new UnitCornTestRunner();

        Result result = utr.runTest(testTestsClass,"public void UnitCornTestRunnerTestTests.testThatFails()");
        String expectedValue = "Test failed with error: java.lang.AssertionError";
        String actualValue = result.getResult();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testRunTest_withPassingTest() {

        UnitCornTestRunner utr = new UnitCornTestRunner();

        Result result = utr.runTest(testTestsClass,"public void UnitCornTestRunnerTestTests.testThatPasses()");
        String expectedValue = "Test passed";
        String actualValue = result.getResult();

        Assert.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testRunTests() {

        UnitCornTestRunner utr = new UnitCornTestRunner();

        String expectedValue = "Test passed\n" +
                "Test failed with error: java.lang.AssertionError\n";
        String actualValue = utr.runTests(testTestsClass);

        Assert.assertEquals(expectedValue, actualValue);
    }
}
