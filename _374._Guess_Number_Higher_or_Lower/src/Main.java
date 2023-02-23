public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution(1702766719);
		System.out.println("Result is " + solution.guessNumber(2126753390));
//		solution = new Solution(145);
//		System.out.println("Result is " + solution.guessNumber(5433));
//		solution = new Solution(543);
//		System.out.println("Result is " + solution.guessNumber(3213));
//		solution = new Solution(6);
//		System.out.println("Result is " + solution.guessNumber(10));
	}

	static class Solution {
		int number;

		public Solution(int number) {
			this.number = number;
		}

		public int guessNumber(int n) {
			long leftBorder = 0;
			long rightBorder = n;
			long mean = -1;
			int predicted;


			while (leftBorder <= rightBorder) {
				mean = (leftBorder + rightBorder) / 2;
				predicted = guess((int) mean);

				if (predicted == 0)
					return (int) mean;

				if (predicted == -1)
					rightBorder = rightBorder == mean ? rightBorder - 1 : mean;
				else
					leftBorder = leftBorder == mean ? leftBorder + 1 : mean;
			}

			return (int) mean;
		}

		int guess(int num) {
			System.out.println("Guessed " + num);
			return Integer.compare(number, num);
		}
	}
}