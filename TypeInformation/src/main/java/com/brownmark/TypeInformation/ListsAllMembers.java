package com.brownmark.TypeInformation;

public class ListsAllMembers {

    public ListsAllMembers () {}

    public double listAllMembers(Class aClass) {
        Object[] fields = aClass.getFields();
        Object[] methods = aClass.getMethods();
        Object[] constructors = aClass.getConstructors();
        for (int i = 0; i < fields.length; i++) {System.out.println(fields[i]);}
        for (int i = 0; i < methods.length; i++) {System.out.println(methods[i]);}
        for (int i = 0; i < constructors.length; i++) {System.out.println(constructors[i]);}
        return fields.length + methods.length + constructors.length;
    }

}
