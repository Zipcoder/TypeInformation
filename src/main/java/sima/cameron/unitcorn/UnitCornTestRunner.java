package sima.cameron.unitcorn;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by cameronsima on 5/3/17.
 */
public class UnitCornTestRunner {

    public Result runTest(Class c, String methodName) {

        Method[] methods = c.getMethods();

        for (Method method : methods) {
            if (methods.toString().equals(methodName)) {
                Result result = new Result(method);
                return result;
            }
        }
    }

    public Result runTest(Method method) {
        Result result = new Result(method);
        return result;
    }

    public String runTests(Class c) {

        Method[] methods = c.getMethods();
        ArrayList<Method> testMethods = getTestMethods(methods);
        ArrayList<Result> results = new ArrayList<>();

        for (Method method : testMethods) {
            Result result = runTest(method);
            results.add(result);
        }



    }

    private ArrayList<Method> getTestMethods(Method[] methods) {
        ArrayList<Method> testMethods = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(getClass("org.junit.Test"))) {
                testMethods.add(method);
            }
        }
        return testMethods;
    }

    private Class getClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }
}
