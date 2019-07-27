import java.util.Arrays;

public class Course0718 {
	public static void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	// a.length 获取数组长度
	public static int indexOf(int[] a, int v) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] == v) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void fill(int[] a, int v) {
		for (int i = 0; i < a.length; i++) {
			a[i] = v;
		}
	}
	
	public static int[] copyOf(int[] original, int newLength) {
		int[] dest = new int[newLength];
		int length = original.length <= newLength ? original.length : newLength;
		for (int i = 0; i < length; i++) {
			dest[i] = original[i];
		}
		
		return dest;
	}
	
	// 前提需要数组是有序的
	public static int binarySearch(int[] a, int v) {
		int left = 0;
		int right = a.length;
		
		while (left < right) {
			int mid = (left + right) / 2;
			if (v == a[mid]) {
				return mid;
			} else if (v < a[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
	
	
	public static int binarySearch2(int[] a, int v) {
		int left = 0;
		int right = a.length - 1;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			if (v == a[mid]) {
				return mid;
			} else if (v < a[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		// 交换下标 0 和 下标 3 的数据
		System.out.println(a);
		System.out.println(Arrays.toString(a));
		
		//fill(a, 1);
		//Arrays.fill(a, 2);
		//swap(a, 0, 3);
		copyOf(a, 10);
		System.out.println(Arrays.toString(Arrays.copyOf(a, 10)));
		
		int[] b = new int[10];
		System.arraycopy(a, 0, b, 5, 5);
		System.out.println(Arrays.toString(b));
	}
}