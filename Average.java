//去掉一个最大数，去掉一个最小数，取平均数
public class Average{
	public static double average(int[] a){
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int sum=0;
		for (int i=0;i<a.length;i++){
			 sum+=a[i];
			if(a[i]>max){
				max=a[i];
			}
			if(a[i]<min){
				min=a[i];
			}
		}
		return (double)(sum - max - min) / (a.length - 2);
	}
	public static void main(String[] args){
		System.out.println(average(
			new int[] { 1, 2, 3, 4.4, 5, }
		));
	}
}