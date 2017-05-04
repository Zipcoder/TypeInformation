package com.brownmark.TypeInformation;

public class classImplementsInterfaceApp {

    public classImplementsInterfaceApp () {}

    public boolean classImplementsInterface(Object objectToBeTested, String possibleInterface) {
        Class anObjectsClass = objectToBeTested.getClass();
        Class<?>[] interfaces = anObjectsClass.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i].toString());
            if (interfaces[i].toString().equals(possibleInterface)) {
                return true;
            }
        }
        return false;
    }
}