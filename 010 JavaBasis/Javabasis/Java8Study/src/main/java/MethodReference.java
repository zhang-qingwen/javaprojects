import org.junit.Test;
import sun.security.util.Length;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

/*
方法引用
 */
public class MethodReference {
    //对象::实例方法名
    @Test
    public void test1() {
//        Consumer<String> con = (x) -> System.out.println(x);

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;
        con1.accept("dfsfdfds");

        Consumer<String> con2 = System.out::println;
        con2.accept("113232323");
    }

    @Test
    public void test2() {
        Employee emp = new Employee("张三", "中国", 30, 100.0);
        Supplier<String> sup = () -> emp.getName();

        System.out.println(sup.get());

        Supplier<Integer> sup2 = emp::getAge;
        System.out.println(sup2.get());
    }

    //类::静态方法名
    @Test
    public void test3() {
//        Comparator<Integer> com = (x, y) -> Integer.compare(x,y);
        Comparator<Integer> com2 = Integer::compare;
        List<Integer> integerList = Arrays.asList(1, 2, 6, 3, 8, 1);

        integerList.sort(com2);
        System.out.println(integerList);

    }

    //类::实例方法名
    public void test4() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> bp2 = String::equals;
    }

    @Test
    public void test5() {
        int x, y, z;
        int a = 10;
        for (x = 1; x < a; x++) {
            for (y = 1; y < a; y++)
                for (z = 1; z < a; z++) {
                    {
                        if (x * 10 + y + z == y * 10 + x && z < 10) {
                            System.out.println((x*10 + y) + "+ " + z + "=" + (y * 10 + x) );
                        }
                    }
                }
        }
    }
}
