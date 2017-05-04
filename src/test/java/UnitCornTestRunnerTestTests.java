import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cameronsima on 5/4/17.
 */
public class UnitCornTestRunnerTestTests {

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
