import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.tribonacci(4) + " must be " + 4);
		System.out.println(solution.tribonacci(25) + " must be " + 1389537);
	}

	static class Solution {
		public int tribonacci(int n) {
			Map<Integer, Integer> map = new HashMap<>();
			if (n == 0)
				return 0;
			else if (n == 1 || n == 2)
				return 1;

			map.put(0,0);
			map.put(1,1);
			map.put(2,1);
			return calculate(n, map);
		}

		private int calculate(int n, Map<Integer, Integer> map) {
			if (map.containsKey(n))
				return map.get(n);

			int res = calculate(n - 3, map) + calculate(n - 2, map) + calculate(n - 1, map);
			map.putIfAbsent(n, res);
			return res;
		}
	}
}