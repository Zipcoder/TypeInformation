package com.brownmark.TypeInformation;

import java.util.ArrayList;

/**
 * Created by markbrown on 5/4/17.
 */
public class ClassHierarchy {

    public ClassHierarchy() {}

    public double getClassHierarchy(Object someObject) {
        ArrayList<String> objectArrayList = new ArrayList<String>();
        Class aClass = someObject.getClass();
        Class aSuperClass = aClass.getClass();
        objectArrayList.add(aSuperClass.toString());
        objectArrayList.add(aClass.toString());
        while (!aSuperClass.toString().equals("class java.lang.Object")) {
            aSuperClass = aSuperClass.getSuperclass();
            objectArrayList.add(0, aClass.toString());
        }
        objectArrayList.add(0, "class java.lang.Object");
        String indent = "";
        for (int i = 0; i < objectArrayList.size(); i++) {
            System.out.println(indent + objectArrayList.get(i));
            indent += "  ";
        }
        return objectArrayList.size();
    }

}
