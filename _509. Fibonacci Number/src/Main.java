public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.fib(0));
		System.out.println(solution.fib(1));
		System.out.println(solution.fib(2));
		System.out.println(solution.fib(3));
		System.out.println(solution.fib(4));
		System.out.println(solution.fib(5));
		System.out.println(solution.fib(6));
	}

	static class Solution {
		public int recursiveFib(int n) {
			return (n == 0 || n == 1) ? n : recursiveFib(n - 1) + recursiveFib(n - 2);
		}

		public int fib(int n) {
			if (n == 0)
				return 0;
			if (n == 1 || n == 2)
				return 1;
			int prev = 0;
			int cur = 1;
			int next = 1;
			int tmp;
			for (int i = 3; i < n; i++) {
				tmp = prev + cur + next;
				prev = cur;
				cur = next;
				next = tmp;
			}
			return cur + prev + next;
		}
	}
}