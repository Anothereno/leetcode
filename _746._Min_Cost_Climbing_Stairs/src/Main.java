import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.minCostClimbingStairs(new int[] {10,15,20}) + " must be " + 15);
		System.out.println(solution.minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}) + " must be " + 6);
	}

	static class Solution {
		public int minCostClimbingStairs(int[] cost) {
			Map<Integer, Integer> map = new HashMap<>();
			return Math.min(recursiveCalculate(cost, 0, map), recursiveCalculate(cost, 1, map));
		}

		private int recursiveCalculate(int[] cost, int currentStep, Map<Integer, Integer> map) {
			if (currentStep >= cost.length)
				return 0;

			if (map.containsKey(currentStep))
				return map.get(currentStep);

			int res = Math.min(cost[currentStep] + recursiveCalculate(cost, currentStep + 1, map), cost[currentStep] + recursiveCalculate(cost, currentStep + 2, map));

			map.putIfAbsent(currentStep, res);
			return res;
		}
	}
}