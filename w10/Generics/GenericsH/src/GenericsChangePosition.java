import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericsChangePosition {
    public static <T> void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static <T> void swap(List<T> l, int i, int j) {
        Collections.<T>swap(l, i, j);
    }

    public static void test() {
        String[] a = {"Hello", "Goodbye"};
        System.out.println("Initial: " + Arrays.toString(a));
        swap(a, 0, 1);
        System.out.println("Final: " + Arrays.toString(a));
        List<Integer> l = new ArrayList<>();
        l.add(1);
        l.add(2);
        System.out.println("Initial: " + l);
        swap(l, 0, 1);
        System.out.println("Final: " + l);
        List<Object> o = new ArrayList<>();
        o.add(100);
        o.add("Test");
        System.out.println("Initial: " + o);
        swap(o, 0, 1);
        System.out.println("Final: " + o);

    }
}
