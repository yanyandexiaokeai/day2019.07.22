public class CalcPi{
	public static double calcPi(int n){
		double pi4=0;
		//n代表多少项的问题，从0开始，所以不能等于
		for(int i=0;i<n;i++){
			int fenum=2*i+1;
			double item=1.0/fenum;
			
			if(n%2==0){
				pi4+=item;
				}else{
				pi4-=item;
				}
		}
		return 4*pi4;
	}
	public static void main(String[] args) {
				System.out.printf("pi = %f%n", calcPi(10000));
	}
}
				