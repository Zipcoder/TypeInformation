package wong.andrew.unitcorn;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by andrewwong on 5/5/17.
 */
public class UnitCornTestRunner {

//    public String runTests(Class testClass){
//
//    }
    public Result runTest(Class testClass, String methodName){
        Result result = new Result();
        Method method = getMethod(testClass, methodName);
        try{
            method.invoke(testClass.newInstance());
            result.setTestHasPassed(true);
        }
        catch(InstantiationException e){
            result.addToExceptionList(e);
        }
        catch(IllegalAccessException e){
            result.addToExceptionList(e);
        }
        catch(InvocationTargetException e){
            result.addToExceptionList(e);
        }
        catch (NullPointerException e){
            result.addToExceptionList(e);
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
