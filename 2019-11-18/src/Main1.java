/*
斐波那契数列
import java.util.*;
public class Main1 {

    public static int Fibonacci(int i) {
        if (i == 0 || i == 1) {
            return i;
        }
        return Fibonacci(i - 1) + Fibonacci(i - 2);
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(Fibonacci(i));
        }

    }
}*/

//求最少多少步变为斐波那契数
//【解题思路】:
//首先构建一个Fibonacci数列，然后从该数列中找到与n最接近的值
// 在构建数列的时候，如果使用递归，就会 因重复计算产生成倍的时间代价，
// 所以用数组的形式 即:A[n]=A[n-1]+A[n-2] 但是数组又会产生额外的空间 花销，
// 考虑到每次迭代只会用前两项的值，所以我们可以只用三个变量 a b c分别表示每次迭代中的 A[n] A[n-1] A[n-2]
// 计算数列的过程中，如果发现某一项大于等于n，则迭代就可以停止了。
// 此时n的值介于最后的 两项之间。这时候只要找到n和这两项距离最小者即可
import java.util.*;
public class Main1 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = 0,b = 1,c = 1;
        while(c < n){
            a = b;
            b = c;
            c = a+b;
        }
        System.out.println(n-b < c-n? n-b:c-n);
    }
}
