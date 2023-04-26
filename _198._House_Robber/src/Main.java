import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.rob(new int[]{1,2,3,1}) + " must be 4");
		System.out.println(solution.rob(new int[]{2,7,9,3,1}) + " must be 12");
	}

	static class Solution {
		public int rob(int[] nums) {
			Map<Integer, Integer> map = new HashMap<>();

			return Math.max(recursiveRob(nums, 0, map), recursiveRob(nums, 1, map));
		}

		private int recursiveRob(int[] nums, int curHouse, Map<Integer, Integer> map) {
			if (curHouse >= nums.length)
				return 0;

			if (map.containsKey(curHouse))
				return map.get(curHouse);

			int result = nums[curHouse] + Math.max(recursiveRob(nums, curHouse + 2, map), recursiveRob(nums, curHouse + 3, map));
			map.putIfAbsent(curHouse, result);
			return result;
		}
	}
}