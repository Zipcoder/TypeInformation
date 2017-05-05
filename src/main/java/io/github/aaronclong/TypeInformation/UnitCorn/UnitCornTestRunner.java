package io.github.aaronclong.TypeInformation.UnitCorn;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * UnitCornTestRunner by aaronlong on 5/4/17.
 */
public class UnitCornTestRunner {

    private Method beforeMethod;
    private Method afterMethod;
    private ArrayList<Method> testList = new ArrayList<>();
    private ArrayList<Result> allResults = new ArrayList<>();

    public Result runTest(Class cls, String method) {
        Result result = Result.makeResultInstance(cls.toString(), method, "NOTRAN");
        try {
            Method m = cls.getMethod(method);
            Object o = cls.newInstance();
            String passOrFail = methodPassOrFail(m, o);
            result = Result.makeResultInstance(cls.toString(), method, passOrFail);
        } catch(Exception e) {
            Result.makeResultInstance(cls.toString(), method, "FAIL");
        }
        return result;
    }

    public Result runTest(Class cls, Object obj, Method method) {
        Result result;
        try {
            String passOrFail = methodPassOrFail(method, obj);
            result = Result.makeResultInstance(cls.toString(), method.toString(), passOrFail);
        } catch(Exception e) {
            result = Result.makeResultInstance(cls.toString(), method.toString(), "FAIL");
        }
        return result;
    }

    public String runTests(Class cls) {
        for (Method method : getUnitMethods(cls)) {
            sortAnnotation(method);
        }

        for (Method test : testList) {
            Object obj = makeObject(cls);
            if (beforeMethod != null) {
               simpleMethodInvoke(test, obj);
            }
            allResults.add(runTest(cls, obj, test));
            if (afterMethod != null) {
                simpleMethodInvoke(test, obj);
            }
        }

        return buildResultString();
    }

    private boolean simpleMethodInvoke(Method theMethod, Object theObject) {
        try {
            theMethod.invoke(theObject);
            return true;
        } catch(InvocationTargetException | IllegalAccessException e) {
            return false;
        }
    }

    private String methodPassOrFail(Method m, Object o) {
        boolean wasMade = simpleMethodInvoke(m, o);
        String methodResult = "FAIL";
        if (wasMade) {
            methodResult = "PASS";
        }
        return methodResult;
    }

    private Method[] getUnitMethods(Class cls) {
        return cls.getMethods();
    }

    private void sortAnnotation(Method m) {
        if (m.isAnnotationPresent(Test.class)) testList.add(m);
        if (m.isAnnotationPresent(Before.class)) beforeMethod = m;
        else if (m.isAnnotationPresent(After.class)) afterMethod = m;
    }

    private Object makeObject(Class cls) {
        try { return cls.newInstance(); }
        catch(Exception e) { return null; }
    }

    private String buildResultString() {
        StringBuilder result = new StringBuilder(1000);
        for (Result r : allResults) {
            result.append(r);
        }

        return result.toString();
    }
}
