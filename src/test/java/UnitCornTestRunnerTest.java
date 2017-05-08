import com.zipcode.typeinformation.DummyTestClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by vidyachandasekhar on 5/7/17.
 */
public class UnitCornTestRunnerTest {
    @Test
    public void runTests() throws Exception {
        //Given
        UnitCornTestRunner unitCornTestRunner = new UnitCornTestRunner();

        //when
        String result = unitCornTestRunner.runTests(DummyTestClass.class);

        //then
        assertNotNull(result);
    }

}