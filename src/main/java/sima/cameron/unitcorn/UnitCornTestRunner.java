package sima.cameron.unitcorn;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by cameronsima on 5/3/17.
 */
public class UnitCornTestRunner {

    public Result runTest(Class c, String methodName) {

        Method method = getMethod(c, methodName);
        Object obj = getClassInstance(c);
        Result result = new Result();
                try {
                    method.invoke(obj);
                } catch (Exception e) {
                    result.setError(e.getCause());
                }
        return result;
    }

    private Method getMethod(Class c, String methodName) {
        Method[] methods = c.getMethods();
        for (Method method : methods) {
            if (method.toString().equals(methodName)) {
                return method;
            }
        }
        return null;
    }

    private Object getClassInstance(Class c) {
        try {
            Object o = c.newInstance();
            return o;
        } catch (InstantiationException e) {
            System.out.println("Can't instantiate");
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
        return null;
    }

/*    public Result runTest(Method method) throws InvocationTargetException, IllegalAccessException {
        Object obj = getClassInstance(method);
        return new Result(method.invoke(obj));

    }*/

    public String runTests(Class c) {

        StringBuilder sb = new StringBuilder();

        Method[] methods = c.getDeclaredMethods();

        ArrayList<Method> testMethods = getTestMethods(methods);

        for (Method method : testMethods) {
            Result result = runTest(c, method.toString());
            sb.append(result.getResult() + "\n");
        }
        return sb.toString();
    }

    public ArrayList<Method> getTestMethods(Method[] methods) {
        ArrayList<Method> testMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                testMethods.add(method);
            }
        }
        return testMethods;
    }
}
