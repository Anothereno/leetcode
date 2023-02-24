import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.climbStairs(2) + " must be " + 2);
		System.out.println(solution.climbStairs(3) + " must be " + 3);
		System.out.println(solution.climbStairs(10) + " must be " + 89);
		System.out.println(solution.climbStairs(15) + " must be " + 987);
		System.out.println(solution.climbStairs(44) + " must be " + 1134903170);
		System.out.println("calls: " + solution.calls);
	}

	static class Solution {
		int calls = 0;
		public int climbStairs(int n) {
			Map<Integer, Integer> map = new HashMap<>();
			return makeStep(n, 1, map) + makeStep(n, 2, map);
		}

		private int makeStep(int totalSteps, int currentStep, Map<Integer, Integer> map) {
			int freeSteps = totalSteps - currentStep;

			if (map.containsKey(freeSteps))
				return map.get(freeSteps);

			calls++;
			if (freeSteps < 0)
				return 0;
			if (freeSteps == 0)
				return 1;

			int res = makeStep(totalSteps, currentStep + 1, map) + makeStep(totalSteps, currentStep + 2, map);

			map.putIfAbsent(freeSteps, res);
			return res;
		}
	}
}