package io.github.aaronclong.TypeInformation.UnitCorn;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by aaronlong on 5/4/17.
 */
public class UnitCornTestRunner {
    public String runTest(Class c, String method) {
        String result = "";
        try {
            Method m = c.getMethod(method);
            Object o = c.newInstance();
            result = m.invoke(o).toString();
            System.out.println(result);
        } catch(Exception e) {
            result = "";
            System.out.println(e);
            e.getCause().printStackTrace();
        }
        return result;
    }

    private Method[] getUnitMethods(Class c) {
        return c.getMethods();
    }

    private Annotation[] getMethodAnnotation(Method m) {
        return m.getDeclaredAnnotations();
    }
}
