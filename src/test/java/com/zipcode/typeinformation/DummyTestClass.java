package com.zipcode.typeinformation;

import org.junit.Test;

/**
 * Created by vidyachandasekhar on 5/7/17.
 */
public class DummyTestClass {

    @Test
    public void allwaysSuccessMethod() {
        System.out.println("this method will always be successful");
    }

    @Test
    public void allwaysFailMethod() throws Exception {
        System.out.println("this method will always throw exception ");
        throw new Exception();
    }
}


