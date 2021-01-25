package day16;

import java.util.*;

public class MapTest3 {

    public static void main(String[] args) {
        String str = charCount("2sdfasad2dadvteter2");
        System.out.println(str);
    }

    public static String charCount(String str) {
        char[] chls = str.toCharArray();
        int count = 0;

        TreeMap<Character, Integer> tm = new TreeMap<Character, Integer>();

        for (int x = 0; x < chls.length; x++) {
            Integer value = tm.get(chls[x]);

            if (value != null)
                count = value;
            count++;

            tm.put(chls[x], count);

            count = 0;
        }
        System.out.println(tm);
        ;
//        return null;

        StringBuffer sb = new StringBuffer();

        Set<Map.Entry<Character, Integer>> entrySet = tm.entrySet();

        Iterator<Map.Entry<Character, Integer>> it3 = entrySet.iterator();

        while (it3.hasNext()) {
            Map.Entry<Character, Integer> me = it3.next();
            Character ch = me.getKey();
            Integer value = me.getValue();

            sb.append(ch + "(" + value + ")");
        }

        return sb.toString();
    }
}