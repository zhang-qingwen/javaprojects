package day16;

import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();

        map.put("01","zhangsan1");
        map.put("02","zhangsan2");
        map.put("03","zhangsan3");
        map.put("08","zhangsan8");

        System.out.println("containskey: " + map.containsKey("022"));
        System.out.println("containskey: " + map.containsKey("02"));
        map.remove("03");
        System.out.println(map);
        System.out.println(map.values());
        System.out.println(map.keySet());

        Set<String> keySet  = map.keySet();

        Iterator<String> it = keySet.iterator();

        while(it.hasNext()){
            String key = it.next();
            System.out.print("key: " + key);
            System.out.println(", Value: " + map.get(key));
        }

        Set<Map.Entry<String, String>> entrySet = map.entrySet();

        Iterator<Map.Entry<String, String>> it1 = entrySet.iterator();

        while (it1.hasNext()){
            Map.Entry<String, String> me = it1.next();

            String key = me.getKey();
            String value = me.getValue();
            System.out.println("Map.Entry key: " + key + ", Value: " + value);
        }
    }
}
