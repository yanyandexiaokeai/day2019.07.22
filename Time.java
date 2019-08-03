public class Time {
	private int hour;
	private int minute;
	private int second;
	
	// 24 小时制
	public Time(int hour, int minute, int second) {
		if (hour < 0 || hour > 23) {
			System.err.println("小时不对");
			return;
		}
		
		if (minute < 0 || minute > 59) {
			System.err.println("分钟不对");
			return;
		}
		
		if (second < 0 || second > 59) {
			System.err.println("秒不对");
			return;
		}
		
		// 属性的初始化
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
	public Time immutableAfter(int seconds) {
		if (seconds < 0) {
			System.err.println("不允许小于 0");
			return null;
		}
		
		Time other = new Time(hour, minute, second);
		other.second += seconds;
		while (other.second >= 60) {
			other.second -= 60;
			other.minute += 1;
			if (other.minute >= 60) {
				other.minute = 0;
				other.hour += 1;
				if (other.hour >= 24) {
					other.hour = 0;
				}
			}
		}
		
		return other;
	}
	
	
	public Time immutableAfter(int minutes, int seconds) {
		return null;
	}
	
	
	public Time immutableAfter(int hours, int minutes, int seconds) {
		return null;
	}
	
	// TODO: a - b 相差多少秒
	public static int diff(Time a, Time b) {
		return 0;
	}
	
	public static void main(String[] args) {
		Time now = new Time(11, 55, 39);
		Time after = now.immutableAfter(100);
		System.out.println(now);
		System.out.println(after);
	}
}