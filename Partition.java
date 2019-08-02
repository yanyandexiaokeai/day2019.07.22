//通过程序分离数组，使偶数在前，奇数在后
import java.util.Arrays;
public class Partition{
	public static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	public static int[] partition1(int[] nums) {
		int begin = 0;
		int end = nums.length - 1;
		// [begin, end] 区间内的数是未判断的数
		// [0, begin)	偶数
		// [end, nums.length) 奇数
		
		while (begin < end) {
			while (begin < end && nums[begin] % 2 == 0) {
				begin++;
			}
			
			while (begin < end && nums[end] % 2 != 0) {
				end--;
			}
			
			swap(nums, begin, end);
		}
		
		return nums;
	}
	public static int[] partition2(int[] nums) {
		int d = 0;//只表示位置
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				swap(nums, i, d);
				d++;
			}
		}
		
		return nums;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(partition2(
			new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9}
		)));
	}
}
