import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.fib(0));
		System.out.println(solution.fib(1));
		System.out.println(solution.fib(2));
		System.out.println(solution.fib(3));
		System.out.println(solution.fib(4));
		System.out.println(solution.fib(5));
		System.out.println(solution.fib(30) + " Calls amount: " + solution.callsAmount);
	}

	static class Solution {
		int callsAmount = 0;
		public int recursiveFib(int n, Map<Integer, Integer> map) {
			if (map.containsKey(n))
				return map.get(n);

			callsAmount++;
			int result = recursiveFib(n - 1, map) + recursiveFib(n - 2, map);
			map.putIfAbsent(n, result);

			return result;
		}

		public int fib(int n) {
			if (n == 0 || n == 1)
				return n;

			Map<Integer, Integer> map = new HashMap<>();
			map.put(0, 0);
			map.put(1, 1);
			return recursiveFib(n, map);
		}

		public int loopedFib(int n) {
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