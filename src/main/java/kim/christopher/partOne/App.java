package kim.christopher.partOne;

import java.lang.reflect.Method;

public class App {

    public static void main(String[] args) {
        Method[] methodArray = Double.class.getMethods();
        for(Method m: methodArray){
            System.out.println(m.toString());
        }
    }


}
