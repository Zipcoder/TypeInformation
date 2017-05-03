package sima.cameron.unitcorn;

import java.lang.reflect.InvocationTargetException;
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

    public Result runTest(Method method) throws InvocationTargetException, IllegalAccessException {
        Object obj = getClassInstance(method);


        Result resultObj = new Result(method.invoke(obj));



        return resultObj;
    }

    public String runTests(Class c) {

        StringBuilder sb = new StringBuilder();

        Method[] methods = c.getMethods();
        ArrayList<Method> testMethods = getTestMethods(methods);

        for (Method method : testMethods) {
            sb.append(runTest(method));
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

    private Object getClassInstance(Method method) {
        try {
            return method.getClass().newInstance();
        } catch (InstantiationException e) {
            return null;

        } catch (IllegalAccessException e) {
            return null;
        }
    }


}
