package sima.cameron.unitcorn;

import java.lang.reflect.Method;

/**
 * Created by cameronsima on 5/3/17.
 */
public class Result {

    private Object error;

    public Result() {
        error = null;
    }

    public void setError(Object object) {
        this.error = object;
    }


    public String getResult() {
        String resultString;
        if (error != null) {
            resultString = "Test failed with error: " + error.toString();
        } else {
            resultString = "Test passed";
        }
        return resultString;
    }

}
