
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by andrewwong on 5/4/17.
 */
public class PartOne {
    private final String newLine = "\n";
    private final String space = " ";
    public boolean classImplementsInterface(Class<?> aClass, String interfaceName) {
        boolean isImplemented = false;
        Class[] interfaces = aClass.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            if (interfaces[i].getSimpleName().equalsIgnoreCase(interfaceName)) {
                isImplemented = true;
                break;
            }
        }
        return isImplemented;
    }
    public String listAllMembers(Object o){
        StringBuilder sb = new StringBuilder();
        String list;
        String fieldList;
        String methodList;
        String constructorList;
        fieldList = listFields(o);
        methodList = listMethods(o);
        constructorList = listConstructors(o);
        sb.append(fieldList);
        sb.append(methodList);
        sb.append(constructorList);
        list = sb.toString();
        return list;
    }

    private String listFields(Object o){
        StringBuilder sb = new StringBuilder();
        Field[] fields = o.getClass().getDeclaredFields();
        for(Field field: fields){
            sb.append(Modifier.toString(field.getModifiers()));
            sb.append(space);
            sb.append(field.getName());
            sb.append(newLine);
        }
        return sb.toString();
    }

    private String listMethods(Object o){
        StringBuilder sb = new StringBuilder();

        Method[] methods = o.getClass().getMethods();
        for(Method method: methods){
            sb.append(Modifier.toString(method.getModifiers()));
            sb.append(space);
            sb.append(method.getName());
            sb.append(newLine);
        }
        return sb.toString();
    }

    private String listConstructors(Object o){
        StringBuilder sb = new StringBuilder();

        Constructor<?>[] constructors = o.getClass().getConstructors();
        for(Constructor constructor: constructors){
            sb.append(Modifier.toString(constructor.getModifiers()));
            sb.append(space);
            sb.append(constructor.getName());
            sb.append(newLine);
        }
        return sb.toString();
    }


}
