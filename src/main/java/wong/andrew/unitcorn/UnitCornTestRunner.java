package wong.andrew.unitcorn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by andrewwong on 5/5/17.
 */
public class UnitCornTestRunner {
    public Result runTest(Class c, String methodName){
        Result result = new Result();
        Method method = getMethod(c, methodName);
        try{
            method.invoke(new UnitCornTestRunner());
        }
        catch(IllegalAccessException e){
            System.out.println(e);
        }
        catch(InvocationTargetException e){
            System.out.println(e);
        }
        return result;
    }
    public Method getMethod(Class c, String methodName){
        Method method = null;
        try{
            method = c.getMethod(methodName);
        }catch(NoSuchMethodException e){
            System.out.println(e);
        }
        return method;
    }
}
