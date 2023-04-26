public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.findTheDistanceValue(new int[]{4,5,8}, new int[]{10,9,1,8}, 2) + " expected 2");
		System.out.println(solution.findTheDistanceValue(new int[]{1,4,2,3}, new int[]{-4,-3,6,10,20,30}, 3) + " expected 2");
		System.out.println(solution.findTheDistanceValue(new int[]{2,1,100,3}, new int[]{-5,-2,10,-3,7}, 6) + " expected 1");
	}

	static class Solution {
		public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
			int res = 0;
			for (int i : arr1) {
				for (int j = 0; j < arr2.length; j++) {
					if (Math.abs(i - arr2[j]) <= d)
						break;
					if (j == arr2.length - 1)
						res++;
				}
			}
			return res;
		}
	}
}