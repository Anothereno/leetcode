import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.deleteAndEarn(new int[]{2,2,3,3,3,4}) + " must be 9");
//		System.out.println(solution.deleteAndEarn(new int[]{3,4,2}) + " must be 6");
//		System.out.println(solution.deleteAndEarn(new int[]{3,1}) + " must be 4");
	}

	static class Solution {
		public int deleteAndEarn(int[] nums) {
			Arrays.sort(nums);
			int[] numArray = new int[nums.length];
			int[] numAmount = new int[nums.length];

			int iterator = -1;
			for (int i = 0; i < nums.length; i++) {
				if (i - 1 >= 0 && nums[i - 1] == nums[i]) {
					numAmount[iterator] += nums[i];
				} else {
					iterator++;
					numArray[iterator] = nums[i];
					numAmount[iterator] = nums[i];
				}
			}

			Map<Integer, Integer> map = new HashMap<>();
			return Math.max(count(map, numArray, numAmount, 0), count(map, numArray, numAmount, 1));
		}

		private int count(Map<Integer, Integer> map, int[] nums, int[] amounts, int curStep) {
			if (curStep >= nums.length || nums[curStep] == 0)
				return 0;

			if (map.containsKey(curStep))
				return map.get(curStep);

			int tailRes = curStep + 1 < nums.length &&  nums[curStep] == nums[curStep + 1] + 1 ? count(map, nums, amounts, curStep + 2) : count(map, nums, amounts, curStep + 1);
			int curRes = amounts[curStep] + tailRes;
			int nextRes = count(map, nums, amounts, curStep + 1);
			map.putIfAbsent(curStep, curRes);
			map.putIfAbsent(curStep + 1, nextRes);
			return Math.max(curRes, nextRes);
		}
	}
}