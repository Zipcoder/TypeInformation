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

    public String runTests(Class c) {
        for (Method method : getUnitMethods(c)) {
            sortMethods(method);
        }
        return "";
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
        else if (m.isAnnotationPresent(After.class)) beforeList.add(m);
    }
}
