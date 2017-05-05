package wong.andrew.unitcorn;

/**
 * Created by andrewwong on 5/5/17.
 */
public class Result {
    private boolean testHasPassed;
    private Exception e;

    public boolean isTestHasPassed() {
        return testHasPassed;
    }

    public void setTestHasPassed(boolean testHasPassed) {
        this.testHasPassed = testHasPassed;
    }

    public Exception getE() {
        return e;
    }

    public void setE(Exception e) {
        this.e = e;
    }
}
