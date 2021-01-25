import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamAPI2 {
    List<Employee> emps = Arrays.asList(
            new Employee("Zhangsan", "中国", 20, 1000.5),
            new Employee("Lisi", "中国", 38, 2000.4),
            new Employee("Wangwu", "中国", 34, 5000.1),
            new Employee("Tianqi","中国",50, 9000.3),
            new Employee("Zhao Liu","中国",31, 4000.3)
    );

    @Test
    public void test1(){
        Stream<Employee> s = emps.stream().filter((e)-> {
            System.out.println("StreamAPI Operation");
            return e.getAge() > 35;
        });
        s.forEach(System.out::println);
    }
}
