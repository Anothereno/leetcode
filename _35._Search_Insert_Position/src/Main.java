public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.searchInsert(new int[]{1, 2, 3, 4}, 2));
		System.out.println(solution.searchInsert(new int[]{1, 2, 3, 4}, 0));
		System.out.println(solution.searchInsert(new int[]{1, 2, 3, 4}, 5));
	}

	static class Solution {
		public int searchInsert(int[] nums, int target) {
			int rightBorder = nums.length - 1;
			int leftBorder = 0;

			if (target < nums[leftBorder])
				return 0;
			else if (target > nums[rightBorder])
				return nums.length;

			int mean;
			while (leftBorder < rightBorder) {
				mean = (leftBorder + rightBorder) / 2;
				if (nums[mean] >= target)
					rightBorder = rightBorder == mean ? rightBorder - 1 : mean;
				else
					leftBorder = leftBorder == mean ? leftBorder + 1 : mean;
			}
			return leftBorder;
		}
	}
}