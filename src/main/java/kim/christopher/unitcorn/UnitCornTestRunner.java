package kim.christopher.unitcorn;

import java.lang.reflect.Method;

public class UnitCornTestRunner {

    public Result runTest(Class c, String methodName){
        Method m = getMethod(c, methodName);
        Object o = instantiateClass(c);
        Result result = new Result();
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
            Object obj = c.newInstance();
            return obj;
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
