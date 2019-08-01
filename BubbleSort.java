/*从前往后
import java.util.Arrays;
public class BubbleSort{
	        // 无序 [0, a.length - i)
			// 有序 [a.length - i, a.length)
			// 冒泡过程
    public static void bubbleSort(int[] a){
        //趟数
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 1; j <a.length-1-i ; j++) {
                if(a[j]>a[j+1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j+1]=tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a={12,4,2,6,8,5};
        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
*/
//从后往前(优化版)
import java.util.Arrays;
public class BubbleSort{
	         // 无序[i, a.length)
			// 有序 [0, i)
	public static void swap(int[] a,int i,int j){
		if(a[i]<a[j]){
				int tmp = a[i];
                    a[i] = a[j ];
                    a[j]=tmp;
	}
}
	public static void bubbleSort(int[] a){
		for(int i=0;i<a.length-1;i++){
			boolean sorted=true;//假设数组有序
			for (int j = a.length - 1; j > i; j--) {
			if(a[j]<a[j-1]){
				swap(a,j,j-1);
				sorted=false;//发生交换，假设为假
			}
			}
			if (sorted == true) {//没发生交换，假设为真，直接打印
				return;
			}
		}
	}
	public static void main(String[] args) {
        int[] a={12,4,2,6,8,5};
        System.out.println(Arrays.toString(a));
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
}
				