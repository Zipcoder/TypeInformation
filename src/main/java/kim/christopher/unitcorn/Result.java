package kim.christopher.unitcorn;

public class Result {

    private boolean successful;
    private String message;


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

    public void setSuccessful(boolean b){
        this.successful = b;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
