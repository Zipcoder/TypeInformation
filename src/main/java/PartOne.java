
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by andrewwong on 5/4/17.
 */
public class PartOne {
    String currentModifier;
    String currentMember;
    String newLine = "\n";
    String space = " ";
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
    public String listAllMembers(Class object){
        StringBuilder stringBuilder = new StringBuilder();
        String list = "";
        int currentModifierEncoding;
        String currentModifier;
        String currentMember;
        String newLine = "\n";
        String space = " ";
        Field[] declaredFields = object.getDeclaredFields();
        Method[] declaredMethods = object.getDeclaredMethods();
        Constructor<?>[] declaredConstructors = object.getDeclaredConstructors();
        for(Field field: declaredFields){
            currentModifierEncoding = field.getModifiers();
            currentModifier = Modifier.toString(currentModifierEncoding);
            currentMember = field.getName();
            stringBuilder.append(currentModifier);
            stringBuilder.append(space);
            stringBuilder.append(currentMember);
            stringBuilder.append(newLine);
        }
        for(Method method: declaredMethods){
            currentModifierEncoding = method.getModifiers();
            currentModifier = Modifier.toString(currentModifierEncoding);
            currentMember = method.getName();
            stringBuilder.append(currentModifier);
            stringBuilder.append(space);
            stringBuilder.append(currentMember);
            stringBuilder.append(newLine);
        }
        for(Constructor constructor: declaredConstructors){
            currentModifierEncoding = constructor.getModifiers();
            currentModifier = Modifier.toString(currentModifierEncoding);
            currentMember = constructor.getName();
            stringBuilder.append(currentModifier);
            stringBuilder.append(space);
            stringBuilder.append(currentMember);
            stringBuilder.append(newLine);
        }
        list = stringBuilder.toString();
        return list;
    }

    public String listFields(Class object, StringBuilder sb){
        Field[] fields = object.getFields();
        for(Field field: fields){
            sb.append(Modifier.toString(field.getModifiers()));
            sb.append(space);
            sb.append(field.getName());
            sb.append(newLine);
        }
        String list = sb.toString();
        return list;
    }

}
