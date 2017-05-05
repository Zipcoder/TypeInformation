package kim.christopher.unitcorn;

import org.junit.runner.Result;

import java.lang.reflect.Method;

public class UnitCornTestRunner {

    public Result runTest(Class c, String methodName){
        return new Result();
    }

    public Method getMethod(Class c, String methodName){
        return Double.class.getMethods()[1];
    }

    public String runTests(Class c){
        return "";
    }

}
