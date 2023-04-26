public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.mySqrt(4) + " expected 2");
		System.out.println(solution.mySqrt(8) + " expected 2");
		System.out.println(solution.mySqrt(16) + " expected 4");
		System.out.println(solution.mySqrt(1) + " expected 1");
	}

	static class Solution {
		public int mySqrt(int x) {
			long leftBorder = 0;
			long rightBorder = x;
			long mean;
			while (leftBorder != rightBorder) {
				mean = (leftBorder + rightBorder) / 2;
				long leftBorderPlusOne = leftBorder + 1;
				if (leftBorderPlusOne * leftBorderPlusOne > x)
					return (int) leftBorder;
				if (mean * mean > x)
					rightBorder = rightBorder == mean ? rightBorder - 1 : mean;
				else
					leftBorder = leftBorder == mean ? leftBorder + 1 : mean;
			}
			return (int) leftBorder;
		}
	}
}