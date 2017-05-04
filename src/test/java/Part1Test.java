import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Currency;
import java.util.List;

/**
 * Created by aurorabanuelos on 5/4/17.
 */
public class Part1Test {

    @Test
    public void classImplementsInterface(){
        //Given
        Part1 part1 = new Part1();
        Class cl = ArrayList.class;
        String inter = Serializable.class.getSimpleName();


        //When
        boolean actual = part1.classImplementsInterface(cl, inter);

        //Then
        Assert.assertEquals(true, actual);
    }

    @Test
    public void listAllMembersTest(){
        //Given
        Part1 part1 = new Part1();
        Class cl = ArrayList.class;

        String expectedResult = 

    }

}
