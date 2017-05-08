package kim.christopher.unitcorn;

public class Result {

    boolean successful;
    String message;


    public Result(){
        successful = false;
        message = "";
    }

    public Result(boolean success, String message){
        this.successful = success;
        this.message = message;
    }


    public boolean isSuccessful() {
        return successful;
    }

    public String getMessage() {
        return message;
    }
}
