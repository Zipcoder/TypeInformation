package weisser.sarah.type_information;

import org.junit.Assert;
import org.junit.Test;
import weisser.sarah.type_inheritance.ClassInvestigator;

/**
 * Created by sarahweisser on 5/6/17.
 */
public class TestClassInvestigator {

    @Test
    public void testCreateArrayOfInterfaces() {

        //given
        Character letter = new Character('j');
        ClassInvestigator investigator = new ClassInvestigator(letter);
        String expectedResult = "interface java.io.Serializable";

        //when
        String[] objectInterfaces = investigator.getObjectInterfaces();
        String actualResult = objectInterfaces[0];

        //then
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testClassImplementsInterface() {

        //given
        Character letter = new Character('j');
        ClassInvestigator investigator = new ClassInvestigator(letter);
        String[] objectInterfaces = investigator.getObjectInterfaces();
        boolean expectedResult = true;

        //when
        boolean actualResult = investigator.classImplementsInterface(letter, "interface java.io.Serializable");

        //then
        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testClassImplementsInterfaceWithUnrecognizedInterfaceName() {

        //given
        Character letter = new Character('j');
        ClassInvestigator investigator = new ClassInvestigator(letter);
        String[] objectInterfaces = investigator.getObjectInterfaces();
        boolean expectedResult = false;

        //when
        boolean actualResult = investigator.classImplementsInterface(letter, "interface java.lang.Appendable");

        //then
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testClassImplementsInterfaceWithClassObject() {

        //given
        try {
            Class cl = Class.forName("java.lang.String");
            ClassInvestigator investigator = new ClassInvestigator(cl);
            String[] objectInterfaces = investigator.getObjectInterfaces();
            boolean expectedResult = true;

            //when
            boolean actualResult = investigator.classImplementsInterface(cl, "interface java.io.Serializable");

            //then
            Assert.assertEquals(expectedResult, actualResult);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



}
