import java.util.*;

public class FilterApple {
    static List<Apple> Inventory = new ArrayList<>();
    static int maxLoop = 15;

    //初始化Inventory
    public static List<Apple> initialInventory(){

        ArrayList<String> al = new ArrayList();
        al.add("Green");
        al.add("Red");
        al.add("Orange");
        al.add("Yellow");
        for(int i=maxLoop-10;i<maxLoop;i++){
            Random r = new Random();
            int s = r.nextInt();
            Apple apple = new Apple(al.get(i%al.size()), Math.abs(r.nextInt(i))*100);
            Inventory.add(apple);
        }

        return Inventory;
    }

    //过滤红色
    public static List<Apple> filterGreenApple(List<Apple> inventory) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("Red".equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    //过滤颜色
    public static List<Apple> filterApplebyColor(List<Apple> inventory, String color) {
        List<Apple> list = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    //行为参数化接口
    @FunctionalInterface
    public interface ApplePredicate{
        boolean filter(Apple apple);
    }

    //基于重量
    public class AppleHeavyWeightPredicate implements ApplePredicate{
        @Override
        public boolean filter(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    //基于颜色
    public class AppleColorPredicate implements ApplePredicate{
        @Override
        public boolean filter(Apple apple) {
            return "Green".equals(apple.getColor());
        }
    }

    //根据抽象条件筛选
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();

        for(Apple apple: inventory){
            if(p.filter(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    //利用抽线条件
    public static class AppleRedAndHeavyPredicate implements ApplePredicate{
        @Override
        public boolean filter(Apple apple) {
            return "Red".equals(apple.getColor()) && apple.getWeight() > 150;
        }
    }

    //匿名类，啰嗦，不太好让人理解

    //行为参数，List抽象接口
    public interface Predicate<T>{
        boolean filter(T e);
    }

    //引入参数性类型，泛型
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e: list){
            if(p.filter(e)){
                result.add(e);
            }
        }
        return result;
    }

    //程序入口
    public static void main(String[] args) throws InterruptedException {
        initialInventory();

        Iterator<Apple> ir = Inventory.iterator();
        while(ir.hasNext()){
            System.out.println(ir.next());
        }


        System.out.println("-------------filter by Red---------------");
        System.out.println(filterGreenApple(Inventory));
        System.out.println("-------------filter by Specific Color---------------");
        System.out.println(filterApplebyColor(Inventory,"Orange"));
        System.out.println("-------------filter by Red & Weight > 150---------------");
        System.out.println(filterApples(Inventory, new AppleRedAndHeavyPredicate()));
        System.out.println("-------------Lambda---------------");
        //Lambda表达式
        List<Apple> result = filterApples(Inventory, apple1->{
            return "Red".equals(apple1.getColor());
        });
        System.out.println(result);
        System.out.println("-------------Thread---------------");
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();

        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();

        Thread.currentThread().join();
    }
}
