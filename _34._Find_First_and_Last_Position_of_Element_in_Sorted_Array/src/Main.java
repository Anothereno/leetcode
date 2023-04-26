import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)) + " expected [3, 4]");
		System.out.println(Arrays.toString(solution.searchRange(new int[]{5,7,7,8,8,10}, 6)) + " expected [-1, -1]");
		System.out.println(Arrays.toString(solution.searchRange(new int[]{}, 0)) + " expected [-1, -1]");
	}

	static class Solution {
		public int[] searchRange(int[] nums, int target) {
			int leftBoard = 0;
			int rightBoard = nums.length - 1;

			if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
				return new int[]{-1, -1};
			while (leftBoard < rightBoard && (nums[leftBoard] != target || nums[rightBoard] != target)) {
				int avg = (leftBoard + rightBoard) / 2;

				if (nums[avg] == target) {
					leftBoard = avg;
					rightBoard = avg;
					break;
				}
				if (nums[avg] > target)
					rightBoard = rightBoard == avg ? rightBoard - 1 : avg;
				else
					leftBoard = leftBoard == avg ? leftBoard + 1 : avg;
			}

			do {
				if (leftBoard - 1 >= 0 && nums[leftBoard - 1] == target)
					leftBoard--;
				if (rightBoard + 1 < nums.length && nums[rightBoard + 1] == target)
					rightBoard++;
			} while ((leftBoard - 1 >= 0 && nums[leftBoard - 1] == target) || (rightBoard + 1 < nums.length && nums[rightBoard + 1] == target));

			if (nums[leftBoard] != target)
				return new int[]{-1, -1};
			return new int[]{leftBoard, rightBoard};
		}
	}
}