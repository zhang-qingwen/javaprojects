package day16;

import java.util.*;

class Student implements Comparable<Student>{
    private String name;
    private int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int compareTo(Student o) {
        int num = new Integer(this.age).compareTo(new Integer(o.age));

        if(num == 0)
            return this.name.compareTo(o.name);
        return num;
    }

    public int hasCode(){
        return name.hashCode()+age*34;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Student)){
            throw new ClassCastException("类型不匹配");
        }
        Student s = (Student) obj;
        return this.name.equals(s.name) && this.age == s.age;
    }
}

public class MapTest {
    public static void main(String[] args) {
        HashMap<Student, String> hm = new HashMap<Student, String>();

        hm.put(new Student("zhangsan1", 21), "Beijing");
        hm.put(new Student("zhangsan1", 21), "Tianjin");
        hm.put(new Student("zhangsan2", 22), "Shanghai");
        hm.put(new Student("zhangsan3", 23), "Nanjing");
        hm.put(new Student("zhangsan4", 24), "Wuhan");

        //Method 1
        Set<Student> keySet = hm.keySet();

        Iterator<Student> it = keySet.iterator();

        while (it.hasNext()){
            Student stu = it.next();
            String addr = hm.get(stu);
            System.out.println(stu+":"+addr);
        }

        System.out.println("--------EntrySet---------------");

        //Method 2, EntrySet
        Set<Map.Entry<Student, String>> entrySet = hm.entrySet();
        Iterator<Map.Entry<Student, String>> itEntrySet = entrySet.iterator();

        while (itEntrySet.hasNext()){
            Map.Entry<Student, String> me = itEntrySet.next();
            Student stu = me.getKey();
            String addr = me.getValue();
            System.out.println(stu+":"+addr);
        }
    }
}