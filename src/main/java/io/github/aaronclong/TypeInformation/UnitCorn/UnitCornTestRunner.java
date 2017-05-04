package io.github.aaronclong.TypeInformation.UnitCorn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by aaronlong on 5/4/17.
 */
public class UnitCornTestRunner {
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

    private Annotation[] getMethodAnnotation(Method m) {
        return m.getDeclaredAnnotations();
    }
}
