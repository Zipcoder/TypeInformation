package unitcorn;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by luisgarcia on 5/5/17.
 */
public class UnitCornTestRunner
{
    public void runTest(Class c, String methodName)
    {
            
    }

    public void runTests(Class c)
    {
        ArrayList<Method> myAnnotationMethod = new ArrayList<Method>();
        Method[] methods = c.getDeclaredMethods();

        while(c != Object.class)
        {
            for(int i = 0; i < methods.length; i++)
            {
                if(methods[i].isAnnotationPresent(Test.class))
                {
                    runTest(c, methods[i].getName() );
                }
            }


        }



    }

}
