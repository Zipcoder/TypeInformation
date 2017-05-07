package kalaygian.dennis.testunitcorn;
import org.junit.Test;
import org.junit.Assert;
import java.util.AbstractList;


/**
 * Created by denniskalaygian on 5/7/17.
 */
public class ImitationTest {

    @Test
    public void testEqualityPass() {
        //Given
        int num1 = 2;
        int num2 = 2;
        //When
        boolean result = (num1 == num2);
        //Then
        Assert.assertTrue("The two numbers are not equal to one another", result);
    }

    // This one is designed to fail
    @Test
    public void testEqualityFail(){
        //Given
        int num1 = 1;
        int num2 = 2;
        //When
        boolean result = (num1 == num2);
        //Then
        Assert.assertTrue("The two numbers are not equal to each other", result);
    }

}
