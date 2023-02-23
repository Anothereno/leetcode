public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.search(new int[]{1, 2}, 2));
		System.out.println(solution.search(new int[]{1, 2}, 3));
		System.out.println(solution.search(new int[]{}, 3));
		System.out.println(solution.search(new int[]{-1, 0, 1, 2, 3}, 3));
		System.out.println(solution.search(new int[]{-1, 0, 1, 2, 3, 6}, 1));
		System.out.println(solution.search(new int[]{-1, 0, 1, 2, 3}, 0));
		System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 9));
		System.out.println(solution.search(new int[]{-1,0,3,5,9,12}, 2));
	}

	static class Solution {
		public int search(int[] nums, int target) {
			if (nums.length == 0)
				return -1;

			int leftPtr = 0, rightPtr = nums.length - 1;
			if (nums[leftPtr] == target)
				return leftPtr;
			if (nums[rightPtr] == target)
				return rightPtr;

			int mean;
			while (leftPtr < rightPtr) {
				mean = (rightPtr - leftPtr) / 2 + leftPtr;

				if (nums[mean] == target)
					return mean;

				if (mean == leftPtr || mean == rightPtr)
					return -1;

				if (nums[mean] > target)
					rightPtr = mean;
				else if (nums[mean] < target)
					leftPtr =  mean;
			}
			return -1;
		}
	}
}