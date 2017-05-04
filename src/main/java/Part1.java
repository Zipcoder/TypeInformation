import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by aurorabanuelos on 5/4/17.
 */
public class Part1 {

    ArrayList interlist = new ArrayList();


    public boolean classImplementsInterface(Object cl, String s) {

        String testInter = cl.getClass().getInterfaces()[0].getSimpleName();

        if(testInter.equals(s)){
            return true;

        }else{

            return false;
        }

    }
}