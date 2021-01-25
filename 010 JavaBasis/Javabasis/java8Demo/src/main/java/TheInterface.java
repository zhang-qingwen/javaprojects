public class TheInterface {
    public static void main(String[] args) {
        Interface01 i1 = () -> {
            System.out.println("hello world");
        };
        System.out.println(i1.getClass().getInterfaces()[0]);
        i1.myMethod01();

        Interface02 i2 = () -> {};
        System.out.println(i2.getClass().getInterfaces()[0]);
    }
}

@FunctionalInterface
interface Interface01{
    void myMethod01();
}

@FunctionalInterface
interface Interface02{
    void myMethod02();
}