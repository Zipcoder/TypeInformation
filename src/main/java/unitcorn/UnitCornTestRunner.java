package unitcorn;

import garcia.luis.TypeInformation;
import org.junit.Assert;
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
        c.getMethod()

    }

    public String runTests(Class c)
    {
        Method[] methods = c.getDeclaredMethods();
                for(int i = 0; i < methods.length; i++)
                {
                    if(methods[i].isAnnotationPresent(Test.class))
                    {
                        runTest(c, methods[i].getName());
                        System.out.println(printAnnotations(methods[i]));
                        return printAnnotations(methods[i]);
                    }
                }

            return "No Results";
    }

    private String printAnnotations(Method method) {
        Annotation[] methodAnnotations = method.getDeclaredAnnotations();
        String methodName= method.getName();
        if(methodAnnotations.length < 1)
        {
            return "There were no annotations associated with the method " + methodName;
        }
        for(Annotation annotation : methodAnnotations)
        {
            String annotationName = annotation.getClass().getName();
            return annotationName;
        }
        return "Fuck";
    }

    public static void main(String[] args)
    {
        UnitCornTestRunner tester = new UnitCornTestRunner();
        Double adouble = 2.332;
//        Class aclass =
//        tester.runTests(Test.class);

    }

}
