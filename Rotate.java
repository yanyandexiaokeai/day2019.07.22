import java.util.Arrays;
public class Rotate{
	//旋转数组，{1，2，3，4，5}
	//当K=3，{3,4，5，1，2}
	public static int[] rotate(int[] nums, int k) {
		k = k % nums.length;
		int[] rightPart = Arrays.copyOfRange(nums, nums.length - k, nums.length);
		//System.out.println(Arrays.toString(rightPart));
		System.arraycopy(nums, 0, nums, k, nums.length - k);
		//System.out.println(Arrays.toString(nums));
		System.arraycopy(rightPart, 0, nums, 0, k);
	
		return nums;
	}
	public static void main(String[] args){
		System.out.println(Arrays.toString(rotate(
			new int[] { 1, 2, 3, 4, 5 },
			3
		)));
		
		System.out.println(Arrays.toString(rotate(
			new int[] { 1, 2, 3, 4, 5 },
			8
		)));
		
		System.out.println(Arrays.toString(rotate(
			new int[] { 1, 2, 3, 4, 5, 6, 7 },
			8
		)));
	}
}