public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.arrangeCoins(1) + " expected 1");
		System.out.println(solution.arrangeCoins(3) + " expected 2");
		System.out.println(solution.arrangeCoins(5) + " expected 2");
		System.out.println(solution.arrangeCoins(8) + " expected 3");
		System.out.println(solution.arrangeCoins(1804289383) + " expected 60070");
		System.out.println(solution.arrangeCoins(2147483647) + " expected 65535");
	}

	static class Solution {
		public int arrangeCoins(int n) {
			if (n == 1)
				return 1;
			long leftBorder = 1;
			long rightBorder = n;
			long avg;
			long N;
			while (leftBorder < rightBorder) {
				avg = (leftBorder + rightBorder) / 2;
				N = getN(avg);
				if (N > n)
					rightBorder = rightBorder == avg ? rightBorder - 1 : avg;
				else {
					if (getN(leftBorder + 1) > n)
						return (int) leftBorder;
					leftBorder = leftBorder == avg ? leftBorder + 1 : avg;
				}
			}
			return (int) rightBorder;
		}

		private long getN(long num) {
			return num * (num + 1L) / 2;
		}
	}
}