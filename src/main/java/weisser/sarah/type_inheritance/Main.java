package weisser.sarah.type_inheritance;

import java.util.ArrayList;
import java.lang.reflect.*;

/**
 * Created by sarahweisser on 5/6/17.
 */
public class Main {

    public static void main(String[] args) {

        String string = "I want tacos.";
        ClassInvestigator investigator = new ClassInvestigator(string);
        System.out.println(investigator.classImplementsInterface(string, "interface java.io.Serializable"));

    }
}
