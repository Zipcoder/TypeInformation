package io.github.aaronclong.TypeInformation.UnitCorn;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created by aaronlong on 5/4/17.
 */


public class StubUnitTest {

    @Before
    public void setUp() {
        System.out.println("Assigning the member fields");
    }

    @Test
    public void failBecauseOfBoolean() {
        Assert.assertTrue("Fake Boolean Test", false);
    }

    @Test
    public void passStringEquality() {
        Assert.assertEquals("Comparing the smae string", "STRING", "STRING");
    }
}
