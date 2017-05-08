package wong.andrew.unitcorn;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by andrewwong on 5/5/17.
 */
public class UnitCornTestRunner {

    public String runTests(Class testClass){
        StringBuilder sb = new StringBuilder();
        Method[] allMethods = testClass.getMethods();
        ArrayList<Method> testMethods;
        ArrayList<String> testMethodNames;
        ArrayList<Result> results = new ArrayList<>();

        testMethods = findAllMethodsWithTestAnnotation(allMethods);
        testMethodNames = findNamesOfAllMethods(testMethods);

        int i = 0;
        for (Method method: testMethods){
            results.add(runTest(testClass, testMethodNames.get(i)));
            i++;
        }
        i = 0;

        for (Result result: results){
            sb.append(testMethodNames.get(i) + ": ");
            if (result.isTestHasPassed() == true)
                sb.append("pass");
            if (result.isTestHasPassed() == false){
                sb.append("fail," + result.getExceptionList());
            }
            sb.append("\n");
            i++;
        }
        String report = sb.toString();
        return report;
    }

    private ArrayList<Method> findAllMethodsWithTestAnnotation(Method[] allMethods){
        ArrayList<Method> testMethods= new ArrayList<>();

        for (int i = 0; i < allMethods.length; i ++){
            if (allMethods[i].isAnnotationPresent(Test.class)){
                testMethods.add(allMethods[i]);
            }
        }
        return testMethods;
    }

    private ArrayList<String> findNamesOfAllMethods(ArrayList<Method> methods){
        ArrayList<String> methodNames = new ArrayList<>();
        for (Method method: methods){
            methodNames.add(method.getName());
        }
        return methodNames;
    }

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
