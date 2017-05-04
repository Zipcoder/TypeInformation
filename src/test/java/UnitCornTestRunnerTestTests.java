import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by cameronsima on 5/4/17.
 */
public class UnitCornTestRunnerTestTests {

    @Before
    public void setUp() {
        System.out.println("Setting up. . .");
    }

    @After
    public void tearDown() {
        System.out.println("Tearing down. . .");
    }

    @Test
    public void testThatPasses() {

        int i = 5;

        Assert.assertEquals(i, i);
    }
    @Test
    public void testThatFails() {

        Assert.assertTrue(false);
    }
}
