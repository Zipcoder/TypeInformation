package wong.andrew.unitcorn;

import java.util.ArrayList;

/**
 * Created by andrewwong on 5/5/17.
 */
public class Result {
    private boolean testHasPassed;
    private ArrayList<Exception> exceptionList = new ArrayList<>();

    public boolean isTestHasPassed() {
        return testHasPassed;
    }

    public void setTestHasPassed(boolean testHasPassed) {
        this.testHasPassed = testHasPassed;
    }

    public ArrayList<Exception> getExceptionList() {
        return exceptionList;
    }

    public void addToExceptionList(Exception e) {
        this.exceptionList.add(e);
    }
}
