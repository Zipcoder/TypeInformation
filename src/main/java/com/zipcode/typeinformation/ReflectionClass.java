package com.zipcode.typeinformation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by vidyachandasekhar on 5/7/17.
 */
public class ReflectionClass {


    public Boolean classImplementsInterface(Object object , String interfaceName){
        Class<?>[] interfaces =   object.getClass().getInterfaces();

        for (Class<?> interfaceType : interfaces ){
            if ( interfaceType.getName().equals(interfaceName)){
                return true;
            }
        }
        return false;
    }


 public String listAllMembers(Object object) {

     Field[] fields = object.getClass().getFields();
     StringBuilder sb = new StringBuilder();

     for (Field field : fields) {
         sb.append("Field Name :" + field.getName() + " Declared class Name : " + field.getDeclaringClass().getName() + " Field modifier :" + field.getDeclaringClass().getModifiers()+"\n");
     }

     Constructor<?>[] constructors  = object.getClass().getConstructors();

     for (Constructor constructor : constructors) {
         sb.append("Constructor Name :" + constructor.getName()+"\n");
     }


     Method[] methods =object.getClass().getDeclaredMethods();
     for (Method method : methods) {
         sb.append("Method Name :" + method.getName()+"\n");
     }

     return sb.toString();
 }

}
