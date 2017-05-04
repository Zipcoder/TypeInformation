package io.github.aaronclong.TypeInformation.UnitCorn;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 * Created by aaronlong on 5/4/17.
 */
public class UnitCornTestRunner {

    private ArrayList<Method> beforeList;
    private ArrayList<Method> testList;
    private ArrayList<Method> afterList;
    private ArrayList<Result> allResults;

    public Result runTest(Class c, String method) {
        Result result = Result.makeResultInstance(c.toString(), method, "NOTRAN");
        try {
            Method m = c.getMethod(method);
            Object o = c.newInstance();
            String passOrFail = methodPassOrFail(m, o);
            result = Result.makeResultInstance(c.toString(), method, passOrFail);
        } catch(Exception e) {
            Result.makeResultInstance(c.toString(), method, "FAIL");
        }
        return result;
    }

    public Result runTest(Class cls, Object obj, Method method) {
        Result result = Result.makeResultInstance(cls.toString(), method.toString(), "NOTRAN");
        try {
            String passOrFail = methodPassOrFail(method, obj);
            result = Result.makeResultInstance(cls.toString(), method.toString(), passOrFail);
        } catch(Exception e) {
            Result.makeResultInstance(cls.toString(), method.toString(), "FAIL");
        }
        return result;
    }

    public String runTests(Class c) {
        Object obj = makeObject(c);
        for (Method method : getUnitMethods(c)) {
            sortMethods(method);
        }
        for (Method m : beforeList) {
            try {
            m.invoke(obj, "");
          } catch (Exception e) { System.out.println(e); }
        }

        for (Method m : testList) {
            allResults.add(runTest(c, obj, m));
        }

        StringBuilder result = new StringBuilder(1000);
        for (Result r : allResults) {
            result.append(r);
        }

        return result.toString();
    }

    private String methodPassOrFail(Method m, Object o) {
        String methodResult = "PASS";
        try { m.invoke(o); }
        catch(InvocationTargetException | IllegalAccessException e) {
            methodResult = "FAIL";
        }
        return methodResult;
    }

    private Method[] getUnitMethods(Class c) {
        return c.getMethods();
    }

    private void sortMethods(Method m) {
        if (m.isAnnotationPresent(Test.class)) testList.add(m);
        else if (m.isAnnotationPresent(Before.class)) beforeList.add(m);
        else if (m.isAnnotationPresent(After.class)) afterList.add(m);
    }

    private Object makeObject(Class cls) {
        try { return cls.newInstance(); }
        catch(Exception e) { return null; }
    }
}
