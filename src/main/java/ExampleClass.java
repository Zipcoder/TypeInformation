/**
 * Created by andrewwong on 5/4/17.
 */
public class ExampleClass {
    private int field1;
    private int field2;
    private String field3;
    private int field4;

    public ExampleClass(){}
    public ExampleClass(String field3){
        this.field3 = field3;
    }

    public ExampleClass(int field2){
        this.field2 = field2;
    }

    public int addFields(int field1, int field2){
        int fieldSum = field1 + field2;
        return fieldSum;
    }
}
