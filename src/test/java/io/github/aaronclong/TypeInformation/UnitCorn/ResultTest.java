package io.github.aaronclong.TypeInformation.UnitCorn;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by aaronlong on 5/4/17.
 */
public class ResultTest {

    private Result construction;

    @Before
    public void setUp() {
        construction = Result.makeResultInstance("Test", "Instantiated", "PASS");
    }

    @Test
    public void testResultConstruction() {
        Assert.assertTrue("Result object was instantiated", construction != null);
    }

    @Test
    public void testToString() {
        Assert.assertEquals("Confirm string evaluation", "METHOD Instantiated IN Test PASS", construction.toString());
    }
}
