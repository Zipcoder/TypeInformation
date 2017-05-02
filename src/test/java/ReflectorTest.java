import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by cameronsima on 5/2/17.
 */
public class ReflectorTest {

    @Test
    public void testClassImplementsInterfaceObject() {

        Reflector reflector = new Reflector();
        ArrayList<Integer> arrayList= new ArrayList<>();

        Assert.assertEquals(true, reflector.classImplementsInterface(arrayList, "List"));
    }

    @Test
    public void testClassImplementsInterfaceString() {

        Reflector reflector = new Reflector();
        ArrayList<Integer> arrayList = new ArrayList<>();
        Assert.assertEquals(true, reflector.classImplementsInterface("ArrayList", "List"));

    }
/*
    @Test
    public void testClassImplementsInterfaceClass() {

        Reflector reflector = new Reflector();
        ArrayList<Integer> arrayList= new ArrayList<>();
        Assert.assertEquals(true, reflector.classImplementsInterface(Class.forName("List"), "List"));
    }*/

}
