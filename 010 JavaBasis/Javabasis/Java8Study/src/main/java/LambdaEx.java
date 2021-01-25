import org.junit.Test;

import java.util.*;

public class LambdaEx {

    List<Employee> emps = Arrays.asList(
            new Employee("Zhangsan", "中国", 20, 1000.5),
            new Employee("Lisi", "中国", 38, 2000.4),
            new Employee("Wangwu", "中国", 34, 5000.1),
            new Employee("Tianqi","中国",50, 9000.3)
            );

    @Test
    public void employeeSort() {
        Collections.sort(emps, (e1,e2) -> {
            if(e1.getAge() == e2.getAge()){
                return e1.getName().compareTo(e2.getName());
            }else{
                return Integer.compare(e1.getAge(),e2.getAge());
            }
        });

        for(Employee emp : emps)
            System.out.println(emp);
    }

    @Test
    public void test2(){
        String upperStr = strHandler("\t\t\t\tabacdeddaeeff ", str -> str.trim().toUpperCase());
        System.out.println(upperStr);
    }

    public String strHandler(String str, MyFunction mf){
        return mf.getValue(str);
    }

    @Test
    public void test3(){
        op(100L, 200L, (x, y) ->x*y);
    }
    public void op(Long l1, Long l2, MyFunction2<Long, Long> mf){
        System.out.println(mf.getValue(l1, l2));
    }

}
