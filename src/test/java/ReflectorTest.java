import com.google.common.io.CharStreams;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import sima.cameron.reflector.Reflector;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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

    @Test
    public void testGetClassMembers() {

        Class cls = new Integer(1).getClass();

        String actualValue = reflector.getClassMembers(cls);

        String expectedValue = "public static final int java.lang.Integer.MIN_VALUE\n" +
                "public static final int java.lang.Integer.MAX_VALUE\n" +
                "public static final java.lang.Class java.lang.Integer.TYPE\n" +
                "static final char[] java.lang.Integer.digits\n" +
                "static final char[] java.lang.Integer.DigitTens\n" +
                "static final char[] java.lang.Integer.DigitOnes\n" +
                "static final int[] java.lang.Integer.sizeTable\n" +
                "private final int java.lang.Integer.value\n" +
                "public static final int java.lang.Integer.SIZE\n" +
                "public static final int java.lang.Integer.BYTES\n" +
                "private static final long java.lang.Integer.serialVersionUID\n" +
                "public java.lang.Integer(int)\n" +
                "public java.lang.Integer(java.lang.String) throws java.lang.NumberFormatException\n" +
                "public static int java.lang.Integer.numberOfLeadingZeros(int)\n" +
                "public static int java.lang.Integer.numberOfTrailingZeros(int)\n" +
                "public static int java.lang.Integer.bitCount(int)\n" +
                "public boolean java.lang.Integer.equals(java.lang.Object)\n" +
                "public static java.lang.String java.lang.Integer.toString(int,int)\n" +
                "public java.lang.String java.lang.Integer.toString()\n" +
                "public static java.lang.String java.lang.Integer.toString(int)\n" +
                "public static int java.lang.Integer.hashCode(int)\n" +
                "public int java.lang.Integer.hashCode()\n" +
                "public static int java.lang.Integer.min(int,int)\n" +
                "public static int java.lang.Integer.max(int,int)\n" +
                "public static int java.lang.Integer.reverseBytes(int)\n" +
                "public int java.lang.Integer.compareTo(java.lang.Integer)\n" +
                "public int java.lang.Integer.compareTo(java.lang.Object)\n" +
                "public byte java.lang.Integer.byteValue()\n" +
                "public short java.lang.Integer.shortValue()\n" +
                "public int java.lang.Integer.intValue()\n" +
                "public long java.lang.Integer.longValue()\n" +
                "public float java.lang.Integer.floatValue()\n" +
                "public double java.lang.Integer.doubleValue()\n" +
                "public static java.lang.Integer java.lang.Integer.valueOf(int)\n" +
                "public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String) throws java.lang.NumberFormatException\n" +
                "public static java.lang.Integer java.lang.Integer.valueOf(java.lang.String,int) throws java.lang.NumberFormatException\n" +
                "public static java.lang.String java.lang.Integer.toHexString(int)\n" +
                "static void java.lang.Integer.getChars(int,int,char[])\n" +
                "public static java.lang.Integer java.lang.Integer.decode(java.lang.String) throws java.lang.NumberFormatException\n" +
                "public static int java.lang.Integer.compare(int,int)\n" +
                "public static int java.lang.Integer.reverse(int)\n" +
                "static int java.lang.Integer.stringSize(int)\n" +
                "public static int java.lang.Integer.sum(int,int)\n" +
                "public static long java.lang.Integer.toUnsignedLong(int)\n" +
                "public static int java.lang.Integer.parseInt(java.lang.String) throws java.lang.NumberFormatException\n" +
                "public static int java.lang.Integer.parseInt(java.lang.String,int) throws java.lang.NumberFormatException\n" +
                "public static java.lang.String java.lang.Integer.toUnsignedString(int)\n" +
                "public static java.lang.String java.lang.Integer.toUnsignedString(int,int)\n" +
                "public static java.lang.String java.lang.Integer.toOctalString(int)\n" +
                "public static java.lang.String java.lang.Integer.toBinaryString(int)\n" +
                "private static java.lang.String java.lang.Integer.toUnsignedString0(int,int)\n" +
                "static int java.lang.Integer.formatUnsignedInt(int,int,char[],int,int)\n" +
                "public static int java.lang.Integer.parseUnsignedInt(java.lang.String) throws java.lang.NumberFormatException\n" +
                "public static int java.lang.Integer.parseUnsignedInt(java.lang.String,int) throws java.lang.NumberFormatException\n" +
                "public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,int)\n" +
                "public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String)\n" +
                "public static java.lang.Integer java.lang.Integer.getInteger(java.lang.String,java.lang.Integer)\n" +
                "public static int java.lang.Integer.compareUnsigned(int,int)\n" +
                "public static int java.lang.Integer.divideUnsigned(int,int)\n" +
                "public static int java.lang.Integer.remainderUnsigned(int,int)\n" +
                "public static int java.lang.Integer.highestOneBit(int)\n" +
                "public static int java.lang.Integer.lowestOneBit(int)\n" +
                "public static int java.lang.Integer.rotateLeft(int,int)\n" +
                "public static int java.lang.Integer.rotateRight(int,int)\n" +
                "public static int java.lang.Integer.signum(int)\n";

        Assert.assertEquals(expectedValue, actualValue);
    }


    @Test
    public void testListAllMembers() {

        try {
            String url = getClass().getClassLoader().getResource("IntegerAllMembers.txt").getFile();
            FileReader reader = new FileReader(url);

            String expectedValue = CharStreams.toString(reader);

            Integer i = new Integer(1);

            String actualValue = reflector.listAllMembers(i);

            Assert.assertEquals(expectedValue, actualValue);
        } catch (IOException e) {
            System.out.println(e);
        }
    }



    @Test
    public void testGetClassHierarchy() {

        Integer i = new Integer(3);

        String expectedValue = "class java.lang.Object\n" +
                "\tclass java.lang.Number\n" +
                "\t\tclass java.lang.Integer\n";

        String actualValue = reflector.getClassHierarchy(i);

        Assert.assertEquals(expectedValue, actualValue);

    }

    @Test
    public void testGetInstancesFromHierarchy_arraysAreEqual() {
        Integer i = new Integer(1);
        Object obj = new Object();

        // Only Object can be instantiated in hierarchy Integer > Number > Object
        List list = new ArrayList();
        list.add(obj);
        Object[] expectedArr = new Object[list.size()];

        List result = reflector.instantiateClassHierarchy(i);
        Object[] resultArr = new Object[result.size()];

        Assert.assertArrayEquals(expectedArr, resultArr);

    }

    @Test
    public void testGetInstancesFromHierarchy_classesAreUnique() {
        Integer i = new Integer(1);
        List result = reflector.instantiateClassHierarchy(i);

        // confirm each list item is an instance of a different class
        Class cls = null;
        for (Object o : result) {
            Assert.assertTrue((o.getClass() != cls));
            cls = o.getClass();
        }
    }

}
