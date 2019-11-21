/*
该题目的输入数据是由 10 个数字组成，表示 0 -9 出现的次数，组成最小数满足下面条件即可:
除0以外1-9中按照从小到大的顺序，将最小的数字输出1次
输出所有出现的0 输出1-9中按照从小到大的顺序，将每个数子输出出现的次数
(第一位输出的数字会在第一次输出的时候减去1)
 */
import java.util.*;
public class MinNum {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int num[]=new int[10];
       //0 - 9
       //输入 0 - 9 这10个数字的出现的个数
        for(int i=0;i<10;i++){
            num[i]=in.nextInt(); }
        //先输出安装1-9的顺序第一个出现的数字1次
        for(int i=1;i<10;i++){
            if(num[i]!=0){
                System.out.print(i);
                num[i]--;
                break;
            }
        }
         //第二位:输出0
         while(num[0]!=0){
               System.out.print(0);
               num[0] --;
         }
        //最后按照1-9的顺序输出
       for(int i=1;i<10;i++){
        while(num[i]!=0){
              System.out.print(i);
              num[i]--;
    }
}
    }

}
