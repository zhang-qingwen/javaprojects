import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class TestLambda {
    List<Apple> appleList = FilterApple.initialInventory();

    @Test
    public void test1(){
        Collections.sort(appleList, (e1,e2) -> {
            if(e1.getWeight() == e2.getWeight()){
                return e1.getColor().compareTo(e2.getColor());
            }else{
                return Integer.compare(e1.getWeight(),e2.getWeight());
            }
        });

        for(Apple apple : appleList){
            System.out.println(apple);
        }
    }

    @Test
    public void test2(){
        String upper = strHandler("sdfdfasdf", (str) -> str.toUpperCase());
        System.out.println(upper);
    }

    public String strHandler(String str, MyFunction mf){
        return mf.getValue(str);
    }
}
