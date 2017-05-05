package io.github.aaronclong.TypeInformation.UnitCorn;

/**
 * Created by aaronlong on 5/4/17.
 */
public class Result {

    private final String theClass;
    private final String theMethod;
    private final String result;

    private Result(String classTested, String methodTested, String actualResult) {
        theClass = classTested;
        theMethod = methodTested;
        result = actualResult;
    }

    public static Result makeResultInstance(String classTested, String methodTested, String actualResult) {
        return new Result(classTested, methodTested, actualResult);
    }

    @Override
    public String toString(){
        return String.format("%s %S\n", theClass, result);
    }
}
