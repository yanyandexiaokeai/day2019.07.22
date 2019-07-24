public class Hannoi {
	// 0, 1, 2
	public static void move(int n, int source, int dest) {
		if (n == 1) {
			System.out.printf("从 %d 移到 %d%n", source, dest);
			return;
		}
		
		int other = 3 - source - dest;
		move(n - 1, source, other);
		System.out.printf("从 %d 移到 %d%n", source, dest);
		move(n - 1, other, dest);
	}
	
	public static void main(String[] args) {
		//Integer.parseInt函数： String "11" -> int 11
		move(Integer.parseInt(args[0]), 0, 2);
	}
}