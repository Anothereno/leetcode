public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPerfectSquare(4));
		System.out.println(solution.isPerfectSquare(14));
		System.out.println(solution.isPerfectSquare(16));
		System.out.println(solution.isPerfectSquare(225));
		System.out.println(solution.isPerfectSquare(1));
		System.out.println(solution.isPerfectSquare(13));
		System.out.println(solution.isPerfectSquare(808201));
	}

	static class Solution {
		public boolean isPerfectSquare(int num) {
			int leftBorder = 1;
			int rightBorder = num / 2;

			if (getSquare(leftBorder) == num)
				return true;
			else if (getSquare(rightBorder) == num)
				return true;
			int mean;
			long currentSquare;

			while (leftBorder < rightBorder) {
				mean = (leftBorder + rightBorder) / 2;
				currentSquare = getSquare(mean);
				if (currentSquare == num)
					return true;
				if (currentSquare > num)
					rightBorder = rightBorder == mean ? rightBorder - 1 : mean;
				else
					leftBorder = leftBorder == mean ? leftBorder + 1 : mean;
			}
			return false;
		}

		private long getSquare(long i) {
			return i * i;
		}
	}
}