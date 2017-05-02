import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * Created by cameronsima on 5/2/17.
 */
public class ReflectorTest {

    private Reflector reflector;
    private Class cls;


    @Before
    public void setUp() {

        reflector = new Reflector();
        try {
            cls = Class.forName("java.util.List");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }


    }

    @Test
    public void testClassImplementsInterfaceObject() {

        ArrayList<Integer> arrayList= new ArrayList<>();

        Assert.assertTrue(reflector.classImplementsInterface(arrayList, "java.util.List"));
    }

    @Test
    public void testClassImplementsInterfaceString() {

        Assert.assertTrue(reflector.classImplementsInterface("java.util.ArrayList", "java.util.List"));

    }
    @Test
    public void testClassImplementsInterfaceClass() {


        Assert.assertTrue(reflector.classImplementsInterface(cls, "java.util.List"));
    }

}
