package kim.christopher;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClassInspectorTest {

    ClassInspector inspector;
    Integer i;
    Class c;


    @Before
    public void initialize() {
        inspector = new ClassInspector();
        i = new Integer(0);
        c = ArrayList.class;
    }

    @Test
    public void classImplementsInterfaceTest(){

        //: When
        boolean result = inspector.classImplementsInterface(c, "List");
        boolean result2 = inspector.classImplementsInterface(Integer.class, "Comparable");

        //: Then
        assertEquals("ArrayList does implement List", true, result);
        assertEquals("Integer does implement Comparable", true, result2);

    }

    @Test
    public void classImplementsInterfaceFailTest(){

        //: When
        boolean result = inspector.classImplementsInterface(c, "Type");

        //: Then
        assertEquals("ArrayList does not implement Type", false, result);

    }

    @Test
    public void listAllMembersTest(){

        //: When
        String result = inspector.listAllMembers(i);

        //: Then
        assertTrue(result.contains("public static final int java.lang.Integer.MIN_VALUE"));
        assertTrue(result.contains("public java.lang.Integer(int)"));
        assertTrue(result.contains("public static int java.lang.Integer.remainderUnsigned(int,int)"));

    }

    @Test
    public void listFieldsTest(){


        //: When
        String result = inspector.listFields(i);

        //: Then
        assertTrue(result.contains("public static final MAX_VALUE"));

    }

    @Test
    public void listConstructorsTest(){

        //: When
        String result = inspector.listConstructors(i);

        //: Then
        assertEquals("Test", "Integer: public java.lang.Integer(int)\n" +
                "Integer: public java.lang.Integer(java.lang.String) throws java.lang.NumberFormatException\n", result.toString());

    }

    @Test
    public void listMethodsTest(){

        //: When
        String result = inspector.listMethods(i);

        //: Then
        assertTrue(result.contains("public float java.lang.Integer.floatValue()"));

    }

    @Test
    public void getClassHierarchyTest(){

        //: When
        String result = inspector.getClassHierarchy(i);
        //: Then
        assertTrue(result.contains("Object") && result.contains("Number"));

    }

    @Test
    public void instantiateClassHierarchyTest(){

        //: When
        ArrayList<Object> result = inspector.instantiateClassHierarchy(i);                                                                                                                                                                                                                                                                                                                                                                                 = inspector.instantiateClassHierarchy(i);

        //: Then
        assertTrue(!result.get(0).getClass().equals(result.get(1).getClass()));
    }
}
