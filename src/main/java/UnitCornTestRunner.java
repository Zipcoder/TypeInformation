import org.junit.Test;

import java.lang.reflect.Method;

/**
 * Created by vidyachandasekhar on 5/7/17.
 */
public class UnitCornTestRunner {

    public Result runTest(Class c, Method methodName) {
        Result result = new Result();

        try{
            methodName.invoke(c.newInstance());
            result.setSuccessTestsDetails("Test on method "+ methodName + " passed");
        } catch (Throwable t){
            result.setFailureTestDetails("Test on method "+ methodName + " failed"  + " cause: "+ t.getCause().getMessage());
        }

        return result;
    }

    public String runTests(Class c) {
        Method[] methods = c.getDeclaredMethods();
        StringBuilder sb = new StringBuilder();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
               Result testResultReport = runTest(c, method);
               sb.append(testResultReport.toString());
            }
        }
        return sb.toString();
    }
}

