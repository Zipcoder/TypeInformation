package com.brownmark.TypeInformation;

public class classImplementsInterfaceApp {

    public classImplementsInterfaceApp () {}

    public boolean classImplementsInterface(Object objectToBeTested, String possibleInterface) {
        Class anObjectsClass = objectToBeTested.getClass();
        Class<?>[] interfaces = anObjectsClass.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            if (interfaces[i].toString().equals(possibleInterface)) {
                return true;
            }
        }
        return false;
    }

    public boolean classImplementsInterface(String classToBeTested, String possibleInterface) {
        try {
            Class aClass = Class.forName(classToBeTested);
            Class<?>[] interfaces = aClass.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                if (interfaces[i].toString().equals(possibleInterface)) {
                    return true;
                }
            }
            return false;
        } catch (ClassNotFoundException e) {
            System.out.println("Class Not Found");
            return false;
        }
    }

    public boolean classImplementsInterface(Class objectToBeTested, String possibleInterface) {
        Class<?>[] interfaces = objectToBeTested.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            if (interfaces[i].toString().equals(possibleInterface)) {
                return true;
            }
        }
        return false;
    }
}