package kalaygian.dennis.unitcorn;
import java.util.ArrayList;

/**
 * Created by denniskalaygian on 5/6/17.
 */
public class Result {

    String methodName;
    String result;

    public Result(String methodName, String result) {
        this.methodName = methodName;
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public String getMethodName() {
        return methodName;
    }

    public String toString() {
        return "Test result of " + methodName + ": " + result + ".\n";
    }
}
