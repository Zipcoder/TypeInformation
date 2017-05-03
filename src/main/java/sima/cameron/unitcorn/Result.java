package sima.cameron.unitcorn;

import java.lang.reflect.Method;

/**
 * Created by cameronsima on 5/3/17.
 */
public class Result {

    private Method method;

    public Result(Method method) {
        this.method = method;
    }

    public Method getMethod() {
        return method;
    }


}
