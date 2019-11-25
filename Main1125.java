//统计同成绩学生人数
/*
【解题思路】
输入和计算过程:
输入人数
循环变量，输入分数
输入目标分数 循环变量分数数组，计算和目标分数相等的分数出现的频次 打印输出目标分数出现的频次
 */
import java.util.Scanner;
public class Main1125 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); while (scan.hasNext()) {
            int N = scan.nextInt();// 输入的人数
            if (N == 0) {// 如果检测到输入的人数为0 则结束
                return;
            }
            int[] arr = new int[N];// 保存N个人的分数
            for (int i = 0; i < arr.length; i++){
                arr[i] = scan.nextInt(); }
            int t = scan.nextInt();// 目标分数 输出击中目标分数的个数
            int count = 0;
            for (int i = 0; i < arr.length; i++){
                if (t == arr[i]) { count++;
                }
            }
            System.out.println(count);
        }
    }
}