package kalaygian.dennis;
import java.util.ArrayList;


public class Main
{
    public static void main( String[] args ) throws ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree(ArrayList.class);
        System.out.println(familyTree.getClassHierarchy());
    }
}
