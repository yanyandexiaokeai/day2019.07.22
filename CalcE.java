public  class CalcE{
	// 利用递归方式计算阶乘
	public static long factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
	
	// 利用迭代方式计算阶乘
	public static long factorial2(int n) {
		int r = 1;
		for (int i = 1; i <= n; i++) {
			//r = r * i;
			r *= i;
		}
		return r;
	}
	public static double calcE(int n){
	     double e=0;
		for(int i=0;i<=n;i++){
			e+=(1.0/factorial(i));
		}
		return e;	
	}
	public static void main(String[] args){
		System.out.printf("e = %f%n", calcE(10000));
	}
}