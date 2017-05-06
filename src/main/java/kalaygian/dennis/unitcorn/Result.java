package kalaygian.dennis.unitcorn;
import java.util.ArrayList;

/**
 * Created by denniskalaygian on 5/6/17.
 */
public class Result {

    private ArrayList<String> results;

    public Result(){
        results = new ArrayList<String>();
    }

    public ArrayList<String> getResults() {
        return results;
    }

    public void addResult(String s){
        results.add(s);
    }

    public void displayResults(){
        System.out.println(results);
    }
}
