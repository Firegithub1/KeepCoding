import java.util.Comparator;

public class ClassComparator implements Comparator<Class<?>> {
    @Override
    public int compare(Class<?> clazz1,Class<?> clazz2) {
        if(clazz1.equals(clazz2)){
            return 0;
        }
        if(clazz1.isAssignableFrom(clazz2)){
            return -1;
        }
        if(clazz2.isAssignableFrom(clazz1)){
            return 1;
        }
        throw new IllegalArgumentException("两个类之间没有关系");
    }
}
