package sima.cameron.unitcorn;

import java.lang.reflect.Method;

/**
 * Created by cameronsima on 5/3/17.
 */
public class Result {

    private Object object;

    public Result(Object object) {
        this.object = object;
    }

    public Object getMethod() {
        return object;
    }


}
