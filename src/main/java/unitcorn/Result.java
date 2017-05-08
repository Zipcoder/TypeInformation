package unitcorn;

/**
 * Created by luisgarcia on 5/5/17.
 */
public class Result
{
    private boolean pass;
    private String method;
    private String theClass;

    public Result(boolean pass, String method, String theClass)
    {
        this.pass = pass;
        this.method = method;
        this.theClass = theClass;
    }

    public boolean getPass()
    {
        return pass;
    }

    public void printResutl()
    {
        System.out.println("Class Tested: " + theClass);
        System.out.println("Method Tested: " + method);
        System.out.println("Pass: " + pass);
    }


}
