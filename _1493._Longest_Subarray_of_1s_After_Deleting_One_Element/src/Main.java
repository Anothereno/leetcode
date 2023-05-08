import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.longestSubarray(new int[] {1,1,0,1}));
		System.out.println(solution.longestSubarray(new int[] {0,1,1,1,0,1,1,0,1}));
		System.out.println(solution.longestSubarray(new int[] {1,1,1}));
		System.out.println(solution.longestSubarray(new int[] {1,0,0,1,1,0,1}));
	}

	static class Solution {
		public int longestSubarray(int[] nums) {
			int left = 0;
			int right = 0;
			boolean deleted = false;
			int max = 0;
			int cur = 0;

			while (right < nums.length) {
				if (nums[right] == 1) {
					right++;
					cur++;
				} else {
					if (!deleted) {
						deleted = true;
						right++;
					} else {
						max = Math.max(max, cur);

						cur -= nums[left];
						deleted = nums[left] != 0;
						left++;
					}
				}
			}

			return Math.max(max, right - left - 1);
		}
	}
}
