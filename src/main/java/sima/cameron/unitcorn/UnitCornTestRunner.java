package sima.cameron.unitcorn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.annotation.Annotation;
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
        Throwable err = catchError(method, obj);
        result.setError(err);
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

    private Throwable catchError(Method method, Object obj) {
        try {
            method.invoke(obj);
        } catch (Exception e) {

            // unwrap InvocationTargetException to get to underlying error, if it exists
            return e.getCause();
        }
        return null;
    }

    public String runTests(Class c) {

        StringBuilder sb = new StringBuilder();

        Method[] methods = c.getDeclaredMethods();

        ArrayList<Method> testMethods = getAnnotatedMethods(methods, Test.class);

        for (Method method : testMethods) {

            runBeforeMethods(methods, c);

            Result result = runTest(c, method.toString());

            runAfterMethods(methods, c);

            sb.append(result.getResult() + "\n");
        }
        return sb.toString();
    }

    private void runBeforeMethods(Method[] methods, Class c) {
        ArrayList<Method> beforeMethods = getAnnotatedMethods(methods, Before.class);
        Method[] resultArr = beforeMethods.toArray(new Method[beforeMethods.size()]);
        runMethods(resultArr, c);
    }

    private void runAfterMethods(Method[] methods, Class c) {
        ArrayList<Method> afterMethods = getAnnotatedMethods(methods, After.class);
        Method[] resultArr = afterMethods.toArray(new Method[afterMethods.size()]);
        runMethods(resultArr, c);
    }

    private void runMethods(Method[] methods, Class c) {
        for (Method method : methods) {
            Object obj = getClassInstance(c);
            Throwable err = catchError(method, obj);
            System.out.println(err);
        }
    }

    public ArrayList<Method> getAnnotatedMethods(Method[] methods, Class annotationClass) {
        ArrayList<Method> methodsArr = new ArrayList<>();

        for (Method method : methods) {
            if (method.isAnnotationPresent(annotationClass)) {
                methodsArr.add(method);
            }
        }
        return methodsArr;
    }

}
