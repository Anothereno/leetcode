import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums;
		nums = new int[]{0,1,0,3,12};
		sol.move(nums);
		System.out.println(Arrays.toString(nums));
		nums = new int[]{0};
		sol.move(nums);
		System.out.println(Arrays.toString(nums));
		nums = new int[]{3,2,1,0,534,3,23,0,0};
		sol.move(nums);
		System.out.println(Arrays.toString(nums));
	}

	public void moveZeroes(int[] nums) {
		int endArray = nums.length - 1;
		int nonZeroIndex = 0;
		int skipZero = 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] != 0)
				nums[nonZeroIndex++] = nums[i];
			else
				skipZero++;
		while (skipZero-- > 0)
			nums[endArray--] = 0;
	}

	static class Solution {
		public void moveZeroes(int[] nums) {
			int rightPointer = nums.length - 1;
			int leftPointer = 0;
			while (leftPointer != rightPointer) {
				while (leftPointer != rightPointer && nums[leftPointer] != 0)
					leftPointer++;
				while (leftPointer != rightPointer && nums[rightPointer] == 0)
					rightPointer--;
				if (leftPointer == rightPointer)
					return;
				int tmp = nums[leftPointer];
				nums[leftPointer] = nums[rightPointer];
				nums[rightPointer] = tmp;
			}
		}


		private void move(int[] array) {
			int nonZeroChIndex = 0;
			int zeroCh = 0;

			for (int i = 0; i < array.length; i++)
				if (array[i] == 0)
					zeroCh++;
				else {
					if (nonZeroChIndex != i)
						array[nonZeroChIndex] = array[i];
					nonZeroChIndex++;
				}
			while (zeroCh != 0) {
				array[array.length - zeroCh] = 0;
				zeroCh--;
			}
		}
	}
}