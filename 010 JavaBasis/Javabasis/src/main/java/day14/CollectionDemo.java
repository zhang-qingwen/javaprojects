package day14;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();

        al.add("Java 01");
        al.add("Java 02");
        al.add("Java 03");
        al.add("Java 04");
        al.add("Java 05");
        al.add("Java 06");

        System.out.println(al);

        Iterator it = al.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
