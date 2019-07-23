public class Course0716 {
	public static void 可以用中文起名字() {
	}
	
	/*
	无法以数字开头
	public static void 0718() {
	}
	*/
	
	public static int max(int a, int b) {
		return a >= b ? a : b;
	}
	
	public static void initVariable() {
		byte a = 10;
		// byte aa = -129;
		short b = 10;
		int c = 10;
		long d = 10;
	}
	
	public static void numberOverflow() {
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;
		
		System.out.println(min);
		System.out.println(max);
		
		System.out.println(min - 1);
		System.out.println(max + 1);
	}
	
	public static void noDefaultValue() {
		int a;
		System.out.println(a);
	}
	
	public static void main(String[] args) {
		// 不用 \n 代表换行	%n 代表换行
		if (args.length > 0) {
			System.out.printf("%s%n", args[0]);
		}
		
		可以用中文起名字();
		
		System.out.println(max(10, 5));
		
		//int a = 10L;
		
		numberOverflow();
	}
}


