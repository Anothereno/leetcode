public class Main {

	public static void main(String[] args) {
		System.out.println(reverse(Integer.MAX_VALUE));
	}

	public static int reverse(int x) {
		int sign = 1;
		int cur;
		if (x > -9 && x < 10)
			return x;
		int res = Math.abs(x % 10);
		if (x < 0) {
			sign = -1;
			x /= -10;
		} else
			x /= 10;
		while (x != 0) {
			cur = res * 10 + (x % 10);
			if (cur < res)
				return 0;
			res = cur;
			x /= 10;
		}
		return sign * res;
	}
}
