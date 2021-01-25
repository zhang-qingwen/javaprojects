import java.util.*;
import java.util.function.*;

public class LambdaUsage {
    //Function Interface
    @FunctionalInterface
    public interface Adder{
        int add(int a, int b);
    }

    @FunctionalInterface
    public interface SmartAdder extends Adder{
        //int add(long a, Long b);
    }

    public static void main(String[] args) {
        Runnable r1 = ()-> System.out.println("Hello World");

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World2");
            }
        };

//        process(r1);
//        process(r2);
//        process(()-> System.out.println("Hello"));

        //Predicate用法
        List<Apple> appleList = FilterApple.initialInventory();

        System.out.println(appleList);

        List<Apple> resultList = filter(appleList,(apple -> apple.getColor().equals("Green")));

        System.out.println(resultList);

        List<Apple> longPredicateResultList = filterByWeight(appleList,w -> w>1000);
        System.out.println(longPredicateResultList);
        //Consumer
        System.out.println("---------Consumer---------");
        simpleTestConsumer(appleList, a-> System.out.println(a));

        //BiConsumer
        biTestConsumer("XXX", appleList, (a,s)-> System.out.println(s+ a.getColor() + ":Weight=>" + a.getWeight()));

        //Function，苹果重量放大十倍
        String str3 = testFunction(new Apple("Yellow", 100),a->a.toString());
        System.out.println(str3);


        //Supplier

        int i = 0;
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                i++;
//            }
//        };
    }

    private static void process(Runnable r){
        r.run();
    }

    private static List<Apple> filter(List<Apple> source, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        for(Apple a:source){
            if(predicate.test(a))
                result.add(a);
        }
        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> source, LongPredicate longPredicate){
        List<Apple> result = new ArrayList<>();
        for(Apple a:source){
            if(longPredicate.test(a.getWeight()))
                result.add(a);
        }
        return result;
    }

    private static void simpleTestConsumer(List<Apple> source, Consumer<Apple> consumer){
        for(Apple a:source){
            consumer.accept(a);
        }
    }

    private static void biTestConsumer(String c, List<Apple> source, BiConsumer<Apple, String> consumer){
        for(Apple a:source){
            consumer.accept(a, c);
        }
    }

    private static String testFunction(Apple apple, Function<Apple, String> fun ){
        return fun.apply(apple);
    }
}
