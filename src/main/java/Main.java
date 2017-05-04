/**
 * Created by andrewwong on 5/4/17.
 */
public class Main {
    public static void main(String[] args) {
        PartOne partOne = new PartOne();
        StringBuilder sb = new StringBuilder();
//        System.out.println(partOne.listAllMembers(ExampleClass.class));
        ExampleClass object = new ExampleClass();
        System.out.println(partOne.listAllMembers(object));
    }
}
