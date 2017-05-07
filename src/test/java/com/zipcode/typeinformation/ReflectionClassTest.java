package com.zipcode.typeinformation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by vidyachandasekhar on 5/7/17.
 */
public class ReflectionClassTest {
    @Test
    public void listAllMembers() throws Exception {
        //given

        ReflectionClass reflectionClass = new ReflectionClass();
        Dog dog = new Dog();
        //when
        String result = reflectionClass.listAllMembers(dog);


        String exptected ="Field Name :name Declared class Name : com.zipcode.typeinformation.Dog Field modifier :1\n" +
                "Constructor Name :com.zipcode.typeinformation.Dog\n" +
                "Method Name :getName\n" +
                "Method Name :setName\n";
        //then
        assertEquals(exptected,result);

    }

    @Test
    public void classImplementsInterfacePositiveCondition() throws Exception {
        //given

        ReflectionClass reflectionClass = new ReflectionClass();
        Dog dog = new Dog();
        //when
        Boolean result = reflectionClass.classImplementsInterface(dog, "com.zipcode.typeinformation.Pet");


        //then
        assertTrue(result);
    }
    @Test
    public void classImplementsInterfaceNegative() throws Exception {
        //given

        ReflectionClass reflectionClass = new ReflectionClass();
        Dog dog = new Dog();
        //when
        Boolean result = reflectionClass.classImplementsInterface(dog, "com.zipcode.typeinformation.Vehicle");


        //then
        assertFalse(result);
    }
}