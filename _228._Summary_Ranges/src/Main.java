import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.summaryRanges(new int[]{0,1,2,4,5,7}));
		System.out.println(solution.summaryRanges(new int[]{0,2,3,4,6,8,9}));
		System.out.println(solution.summaryRanges(new int[]{}));
		System.out.println(solution.summaryRanges(new int[]{0}));
		System.out.println(solution.summaryRanges(new int[]{0, 1, 2, 3}));
		System.out.println(solution.summaryRanges(new int[]{0, 2, 4, 6}));
	}

	static class Solution {
		public List<String> summaryRanges(int[] nums) {
			if (nums.length == 0)
				return new ArrayList<>();

			List<String> list = new ArrayList<>();
			int start = nums[0];
			int end = nums[0];

			for (int i = 1; i < nums.length; i++) {
				if (nums[i] == end + 1) {
					end = nums[i];
				} else {
					list.add(start == end ? String.valueOf(start) : start + "->" + end);

					start = nums[i];
					end = nums[i];
				}
			}

			list.add(start == end ? String.valueOf(start) : start + "->" + end);
			return list;
		}
	}
}