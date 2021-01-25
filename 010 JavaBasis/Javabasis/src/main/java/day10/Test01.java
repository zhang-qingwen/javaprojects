package day10;

public class Test01 {
    public static void func() throws Exception{
        try{
            System.out.println(1/0);
            //throw new Exception();
        }finally {
            System.out.println("B");
        }
    }
    public static void main(String[] args) {
        try{
            func();
            System.out.println("A");
        }catch (Exception e){
            System.out.println("C");
        }
        System.out.println("D");
    }
}