package io.github.aaronclong.TypeInformation.UnitCorn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by aaronlong on 5/4/17.
 */
public class UnitCornTestRunner {
    public String runTest(Class c, String method) {
        String result = "";
        try {
            Method m = c.getMethod(method);
            Object o = c.newInstance();
            result = methodPassOrFail(m, o);
        } catch(Exception e) { }
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
