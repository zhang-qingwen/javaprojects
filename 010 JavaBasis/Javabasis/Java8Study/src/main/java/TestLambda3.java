import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.*;

public class TestLambda3 {

    //消费型接口
    @Test
    public void test1() {
        happy(10000, (money) -> System.out.println("我消费了" + money));
    }

    public void happy(double money, Consumer<Double> con) {
        con.accept(money);
    }

    //BiConsumer
    @Test
    public void test5(){
        biConsumerTest(1000,"zhangsan", (money, name) -> System.out.println(name + "消费了" + money));
    }
    public void biConsumerTest(double money, String name, BiConsumer<Double, String> con){
        con.accept(money, name);
    }
    //供给型接口
    @Test
    public void test2() {
        List<Integer> numList = getNumList(10, () -> (int) (Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }

    public List<Integer> getNumList(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }

    //函数型接口
    @Test
    public void test3() {
        String newStr = strHandler("\t\t\t\t\t\t，我的程序 aabaccdesdd ", str -> str.trim().toUpperCase());

        System.out.println(newStr);
        String newStr1 = strHandler("\t\t\t\t\t\t，我的程序 aabaccdesdd ", str -> str.substring(2,15));
        System.out.println(newStr1);
    }

    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    //谓词型接口
    @Test
    public void test4(){
        List<String> list = Arrays.asList("Hello", "Wolrd", "ww", "ok");
        List<String> filterstr = filterStr(list,s->s.length()>3);
        for (String str: filterstr){
            System.out.println(str);
        }
    }

    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> strList = new ArrayList<>();
        for (String str:list) {
            if(pre.test(str)){
                strList.add(str);
            }
        }
        return strList;
    }

}
