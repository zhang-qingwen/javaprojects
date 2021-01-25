import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo {
    public static void main(String[] args) {
        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> appleList = FilterApple.initialInventory();

        System.out.println(appleList);

        appleList.sort(byColor);

        System.out.println(appleList);

        Comparator<Apple> byWeight = ((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));

        appleList.sort(byWeight);
        System.out.println(appleList);

        System.out.println("--------------");
        Function<String, Integer> stringFunction = s-> s.length();
        System.out.println(stringFunction);
        System.out.println("--------------");

        Predicate<Apple> p = a->a.equals("Green");
        System.out.println(p.toString());

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];

        }
    }
}
