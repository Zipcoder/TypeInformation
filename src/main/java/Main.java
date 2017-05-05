import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by andrewwong on 5/4/17.
 */
public class Main {
    public static void main(String[] args) {
        PartOne partOne = new PartOne();
        StringBuilder sb = new StringBuilder();
        ExampleClass object = new ExampleClass();
//        System.out.println(partOne.listAllMembers(object));
//        System.out.println(partOne.getClassHierarchy(new Menu()));
        ArrayList<Object> instances = partOne.instantiateClassHierarchy(new Integer(0));
        for(Object o: instances){
            System.out.println(o.getClass().getSimpleName());
        }
    }
}
