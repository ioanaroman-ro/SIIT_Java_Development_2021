import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsMax {

    public static <T extends Comparable<? super T>> T maximalElement (List<T> list) {
        T max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            T elem1 = list.get(i);
            if (elem1.compareTo(max) > 0) {
                max = elem1;
            }
        }
        return max;
    }

    public static void test() {
        List<Integer> c = Arrays.asList(1, 2, 3, 4, 5, 1000, 6, 7, 8, 9, 10);
        System.out.println("Din lista " + c.toString() + " maxim este:");
        System.out.println(GenericsMax.maximalElement(c));
        List<String> s = Arrays.asList("a", "b", "A", "c");
        System.out.println("Din lista " + s.toString() + " maxim este:");
        System.out.println(GenericsMax.maximalElement(s));
    }
}
