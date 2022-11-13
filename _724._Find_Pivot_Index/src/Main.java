import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.pivotIndex(new int[]{1,7,3,6,5,6}));
		System.out.println(solution.pivotIndex(new int[]{1,2,3}));
		System.out.println(solution.pivotIndex(new int[]{2,1,-1}));
		System.out.println(solution.pivotIndex(new int[]{-1,-1,-1,-1,-1,0}));
		System.out.println(solution.pivotIndex(new int[]{-1,-1,0,-1,-1,0}));
	}

	static class Solution {
		public int pivotIndex(int[] nums) {
			int leftSide = 0;
			int rightSide = Arrays.stream(nums).sum();

			for (int i = 0; i < nums.length; i++) {
				rightSide -= nums[i];
				if (leftSide == rightSide)
					return i;
				leftSide += nums[i];
			}

			return -1;
		}
	}
}