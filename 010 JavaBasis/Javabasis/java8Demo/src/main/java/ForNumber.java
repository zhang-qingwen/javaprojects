import java.util.ArrayList;
import java.util.Random;

public class ForNumber {

    static int maxLoop = 1000;
    public static void main(String[] args) {
        int change;
        ArrayList<Integer> al = initialIntegerArrayList();
        System.out.println(al);

        for(int a = 0; a < al.size()-1; a++){
            for(int b = 0; b < al.size()-a-1; b++){
                if(al.get(b) > al.get(b+1)){
                    change = al.get(b);
                    al.set(b, al.get(b+1));
                    al.set(b+1, change);
                }
            }
        }
        System.out.println(al);

    }

    static ArrayList<Integer> initialIntegerArrayList() {
        ArrayList<Integer> al = new ArrayList();
        for (int i = maxLoop - 50; i < maxLoop; i++) {
            Random r = new Random();
            int s = r.nextInt(i);
            al.add(s);
        }
        return al;
    }
}
