package kim.christopher.unitcorn;

import org.junit.runner.Result;

import java.lang.reflect.Method;

public class UnitCornTestRunner {

    public Result runTest(Class c, String methodName){
        return new Result();
    }

    //used in runTest
    public Method getMethod(Class c, String methodName){
        Method[] methods = c.getMethods();
        for(Method method: methods){
            if(methodName.toString().equals(method.getName()))
                return method;
        }
        return null;
    }

    public Object instantiateClass(Class c){
        try {
            Object object = c.newInstance();
            return object;
        } catch (InstantiationException e) {
            System.out.println(c.getSimpleName() + ": could not instantiate!");
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
        return null;
    }

    public String runTests(Class c){
        return "";
    }

}
