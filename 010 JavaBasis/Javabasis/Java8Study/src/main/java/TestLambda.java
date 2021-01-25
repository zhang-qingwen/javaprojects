import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

public class TestLambda {
    @Test
    public void test01() {
        //无参数
        Runnable r = () -> System.out.println("hello lambda!");
        r.run();

        System.out.println("-------------------");

        //一个参数，无返回值
        Consumer<String> con = (s) -> System.out.println(s);
        con.accept("Hello Consumer");

        //若只有一个参数，那么参数的小括号可以省略不写
        Consumer<String> con1 = s -> System.out.println(s);
        con.accept("Hello Consumer，无括号");

        System.out.println("-------------------");
    }

    @Test
    public void test3() {
        //有两个以上参数，Lambda体中有多条语句，并且有返回值
        Comparator<Integer> com = (x, y) -> {
            System.out.println("多条语句");
            return Integer.compare(x, y);
        };
    }

    @Test
    public void test5(){
        Integer y = operation(100, x -> x/x);
        System.out.println(y);
    }

    public Integer operation(Integer num, MyFun mf){
        return mf.getValue(num);
    }
}
