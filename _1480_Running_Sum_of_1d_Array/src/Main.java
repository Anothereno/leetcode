import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		;
		System.out.println(Arrays.toString(solution.runningSum(new int[]{1, 2, 3, 4})));
	}

	static class Solution {
		public int[] runningSum(int[] nums) {
			if (nums.length == 0)
				return nums;
			for (int i = 1; i < nums.length; i++) {
				nums[i] = nums[i - 1] + nums[i];
			}
			return nums;
		}
	}
}