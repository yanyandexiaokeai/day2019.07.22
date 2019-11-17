import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n>1000){
            n = 999;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            arrayList.add(i);
        }
        int i=0;
        while(arrayList.size() >1){
                i = (i+2)%arrayList.size();
                arrayList.remove(i);
        }
        System.out.println(arrayList.get(0));

    }
}