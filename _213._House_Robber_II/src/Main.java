import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.rob(new int[]{2,3,2}) + " must be 3");
		System.out.println(solution.rob(new int[]{1,2,3,1}) + " must be 4");
		System.out.println(solution.rob(new int[]{1,2,3}) + " must be 3");
		System.out.println(solution.rob(new int[]{1}) + " must be 1");
	}

	static class Solution {
		public int rob(int[] nums) {
			if (nums.length == 1)
				return nums[0];
			Map<Integer, Integer> map1 = new HashMap<>();
			Map<Integer, Integer> map2 = new HashMap<>();

			return Math.max(recursiveRob(nums, 0, map1, true, false), recursiveRob(nums, 0, map2, false, true));
		}

		private int recursiveRob(int[] nums, int curHouse, Map<Integer, Integer> map, boolean tookPrev, boolean tookFirst) {
			if (curHouse >= nums.length || curHouse == nums.length - 1 && tookFirst)
				return 0;

			if (tookPrev)
				return recursiveRob(nums, curHouse + 1, map, false, tookFirst);

			if (map.containsKey(curHouse))
				return map.get(curHouse);

			int result = Math.max(recursiveRob(nums, curHouse + 1, map, false, tookFirst), nums[curHouse] + recursiveRob(nums, curHouse + 1, map, true, tookFirst));
			map.putIfAbsent(curHouse, result);
			return result;
		}
	}
}