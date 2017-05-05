
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * Created by andrewwong on 5/4/17.
 */
public class PartOne {
    private final String newLine = "\n";
    private final String space = " ";
    private final String doubleSpace = "  ";

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

    public String listAllMembers(Object o) {
        StringBuilder sb = new StringBuilder();
        String list;
        String fieldList;
        String methodList;
        String constructorList;
        fieldList = listFields(o);
        methodList = listMethods(o);
        constructorList = listConstructors(o);
        sb.append("Fields:\n");
        sb.append(fieldList);
        sb.append("Methods:\n");

        sb.append(methodList);
        sb.append("Constructors:\n");

        sb.append(constructorList);
        list = sb.toString();
        return list;
    }

    private String listFields(Object o) {
        StringBuilder sb = new StringBuilder();
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            sb.append(o.getClass().getSimpleName());
            sb.append(space);
            sb.append(Modifier.toString(field.getModifiers()));
            sb.append(space);
            sb.append(field.getName());
            sb.append(newLine);
        }
        return sb.toString();
    }

    private String listMethods(Object o) {
        StringBuilder sb = new StringBuilder();

        Method[] methods = o.getClass().getMethods();
        for (Method method : methods) {
            sb.append(method.getDeclaringClass().getSimpleName());
            sb.append(space);
            sb.append(Modifier.toString(method.getModifiers()));
            sb.append(space);
            sb.append(method.getName());
            sb.append(newLine);
        }
        return sb.toString();
    }

    private String listConstructors(Object o) {
        StringBuilder sb = new StringBuilder();

        Constructor<?>[] constructors = o.getClass().getConstructors();
        for (Constructor constructor : constructors) {
            sb.append(constructor.getDeclaringClass().getSimpleName());
            sb.append(space);
            sb.append(Modifier.toString(constructor.getModifiers()));
            sb.append(space);
            sb.append(constructor.getName());
            sb.append(newLine);
        }
        return sb.toString();
    }

    public String getClassHierarchy(Object o) {
        StringBuilder sb = new StringBuilder();
        String hierarchy;
        Class currentClass = o.getClass();
        ArrayList<Class> listOfClasses = new ArrayList<>();
        for (int i = 0; currentClass != null; i++) {
            listOfClasses.add(currentClass);
            currentClass = currentClass.getSuperclass();
        }
        for(int i = listOfClasses.size(); i > 0; i--){
            sb.append(listOfClasses.get(i-1) + "\n");
            for (int k = listOfClasses.size(), topClass = listOfClasses.size() - 1; k >= i; k--){
                sb.append(doubleSpace);
            }
        }
//        for (int i = 0; currentClass != null; i++) {
//            sb.append(currentClass + "\n");
//            for (int j = 0; j <= i; j++) {
//                if(currentClass.getSuperclass()==null){
//                    break;
//                }
//                sb.append(doubleSpace);
//            }
//            currentClass = currentClass.getSuperclass();
//        }
        hierarchy = sb.toString();
        return hierarchy;
    }


}
