import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/*
Stream 操作步骤
1: 创建Stream
2: 中间操作
3: 终止操作（终端操作）
 */
public class StreamAPI {

    //创建Stream
    @Test
    public void test1(){
        //1: 通过Collection集合提供的Stream()或者ParallelStream()方法可以获取流
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2: 通过Arrays中的静态方法Stream获取数组流
        Employee[] emps = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(emps);

        //3: 通过Stream类中的静态方法
        Stream<String> stream3 = Stream.of("aaa", "Bbb", "Ccc");

        //4:创建无限流
        //迭代
        Stream<Integer> stream4 = Stream.iterate(10, (x)->x+2).limit(10);
        stream4.forEach(System.out::println);

        //生成
        Stream.generate(()->Math.random()).limit(10)
                .forEach(System.out::println);

    }
}
