import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by aurorabanuelos on 5/5/17.
 */
public class Main {

    public static void main(String[] args) {
        Part1 tst = new Part1();

        System.out.println(tst.classImplementsInterface(ArrayList.class, Serializable.class));

        tst.getClassHierarchy(ArrayList.class);

        tst.listAllMembers(ArrayList.class);
    }
}
