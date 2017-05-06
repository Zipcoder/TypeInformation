package kalaygian.dennis.testunitcorn;

import org.junit.Test;
import org.junit.Assert;
import kalaygian.dennis.unitcorn.*;
import java.util.ArrayList;

/**
 * Created by denniskalaygian on 5/6/17.
 */
public class TestResult {

    @Test
    public void testAddResult(){
        //Given
        Result result = new Result();
        ArrayList<String> expectedResults = new ArrayList<String>();
        expectedResults.add("Error: Test failed");
        //When
        result.addResult("Error: Test failed");
        //Then
        Assert.assertEquals("Incorrect error message was added to the arraylist of errors", result.getResults(), expectedResults);
    }
}
