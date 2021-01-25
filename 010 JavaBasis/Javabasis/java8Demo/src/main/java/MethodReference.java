import java.util.List;
import java.util.function.Consumer;

public class MethodReference {
    public static void main(String[] args) {
        Consumer<String> consumer = (s)-> System.out.println(s);
//        useConsumer(consumer, "Hello World");
//        useConsumer(System.out::println, "Hello world!");

        List<Apple> appleList = FilterApple.initialInventory();

        System.out.println(appleList);

        appleList.sort((a1, a2)->a1.getColor().compareTo(a2.getColor()));

        System.out.println(appleList);
    }

    private static <T> void useConsumer(Consumer<T> consumer, T t){
        consumer.accept(t);
        consumer.accept(t);
    }
}


