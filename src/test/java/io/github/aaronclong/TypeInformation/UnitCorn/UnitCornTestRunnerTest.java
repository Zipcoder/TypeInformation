package io.github.aaronclong.TypeInformation.UnitCorn;

import com.google.common.io.CharStreams;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by aaronlong on 5/4/17.
 */
public class UnitCornTestRunnerTest {

    private UnitCornTestRunner unitCorn;
    private Class stubUnitTest;

    @Before
    public void setUp() {
        try {
            unitCorn = new UnitCornTestRunner();
            stubUnitTest = Class.forName("io.github.aaronclong.TypeInformation.UnitCorn.StubUnitTest");
        } catch(ClassNotFoundException e) {

        }
    }

    @Test
    public void runTestUnitTest() {
        Assert.assertEquals(
                   "METHOD failBecauseOfBoolean IN class io.github.aaronclong.TypeInformation.UnitCorn.StubUnitTest FAIL\n",
                   unitCorn.runTest(stubUnitTest, "failBecauseOfBoolean").toString());
    }

    @Test
    public void runTestRunnersUnitTest() {
        try {
            String url = getClass().getClassLoader().getResource("runTestPrettyPrint.txt").getFile();
            FileReader reader = new FileReader(url);
            String result = CharStreams.toString(reader);
            System.out.println(unitCorn.runTests(stubUnitTest));
            Assert.assertEquals("Confirming pretty log of test runner",
                    result, unitCorn.runTests(stubUnitTest));
        } catch(IOException e) { System.out.println(e); }
    }
}
