package kim.christopher;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClassInspectorTest {

    ClassInspector inspector;
    Class c;


    @Before
    public void initialize() {
        inspector = new ClassInspector();
        c = ArrayList.class;
    }

    @Test
    public void classImplementsInterfaceTest(){

        //: When
        boolean result = inspector.classImplementsInterface(c, "List");

        //: Then
        assertEquals("ArrayList does implement List", true, result);

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

        //: Given

        //: When

        //: Then

    }

    @Test
    public void getClassHierarchyTest(){

        //: Given

        //: When

        //: Then

    }

    @Test
    public void instantiateClassHierarchyTest(){

        //: Given

        //: When

        //: Then

    }
}
