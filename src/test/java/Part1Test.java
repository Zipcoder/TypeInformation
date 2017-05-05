import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Created by aurorabanuelos on 5/4/17.
 */
public class Part1Test {

    @Test
    public void classImplementsInterface(){

        //Given
        Part1 part1 = new Part1();
        Class cls = ArrayList.class;
        Class inter = Serializable.class;

        //When
        boolean actual = part1.classImplementsInterface(cls, inter);

        //Then
        Assert.assertEquals(true, actual);
    }

//    @Test
//    public void listAllMembersTest(){
//
//        //Given
//        Part1 part1 = new Part1();
//        Class cls = ArrayList.class;
//
//        String expectedResult = "  ";
//
//        //When
//        String actualResult = part1.listAllMembers();
//
//        //Then
//        Assert.assertEquals(expectedResult, actualResult);
//
//    }

}
