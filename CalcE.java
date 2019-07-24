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
	/**
     * 利用公式
     * e = 1/0! + 1/1! + 1/2! + 1/3! + 1/4! + ...
     * 计算自然对数的底 e
     * @param n 计算多少项
     * @return
     */
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
