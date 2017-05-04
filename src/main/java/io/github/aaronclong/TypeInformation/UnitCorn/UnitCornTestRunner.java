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

    private Method beforeMethod;
    private Method afterMethod;
    private ArrayList<Method> testList = new ArrayList<Method>();
    private ArrayList<Result> allResults = new ArrayList<Result>();

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
        for (Method method : getUnitMethods(c)) {
            sortMethod(method);
        }

        for (Method test : testList) {
            Object obj = makeObject(c);
            if (beforeMethod != null) {
               try { beforeMethod.invoke(obj, ""); }
               catch(Exception e) { }
            }
            try {
                allResults.add(runTest(c, obj, test));
            }
            catch(Exception e) { }
            if (afterMethod != null) {
                try { afterMethod.invoke(obj, ""); }
                catch(Exception e) { }
            }
        }

        return buildResultString();
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

    private void sortMethod(Method m) {
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
