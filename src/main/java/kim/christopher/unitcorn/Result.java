package kim.christopher.unitcorn;

public class Result {

    boolean wasSuccessful;
    String message;


    public Result(){
        wasSuccessful = false;
        message = "";
    }

    public Result(boolean success, String message){
        wasSuccessful = success;
        this.message = message;
    }

    public void setWasSuccessful(boolean wasSuccessful){
        this.wasSuccessful = wasSuccessful;
    }

    public boolean isWasSuccessful() {
        return wasSuccessful;
    }

    public String getMessage() {
        return message;
    }
}
