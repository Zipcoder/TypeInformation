package unitcorn;

import garcia.luis.TypeInformation;
import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


/**
 * Created by luisgarcia on 5/5/17.
 */
public class UnitCornTestRunner
{
    public Result runTest(Class c, String methodName)
    {

        boolean pass = false;
        try {
            Method m = c.getMethod(methodName);
            Object obj = c.newInstance();
            pass = methodPass(m, obj);

        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        Result myResult = new Result(pass,methodName, c.getName());
        return myResult;
    }

    public String runTests(Class c)
    {
        Method[] methods = c.getDeclaredMethods();
                for(int i = 0; i < methods.length; i++)
                {
                    if(methods[i].isAnnotationPresent(Test.class))
                    {
                        runTest(c, methods[i].getName());
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

    public boolean methodPass(Method method, Object obj)
    {
        boolean pass = false;
        try {
            method.invoke(obj);
            pass = true;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return pass;
    }

    public static void main(String[] args)
    {
        UnitCornTestRunner tester = new UnitCornTestRunner();
        Double adouble = 2.332;
//        Class aclass =

    }

}
