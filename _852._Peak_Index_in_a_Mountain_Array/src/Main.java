public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.peakIndexInMountainArray(new int[]{0,1,0}));
		System.out.println(solution.peakIndexInMountainArray(new int[]{0,2,1,0}));
		System.out.println(solution.peakIndexInMountainArray(new int[]{0,10,5,2}));
		System.out.println(solution.peakIndexInMountainArray(new int[]{0,10,50,2}));
	}

	static class Solution {
		public int peakIndexInMountainArray(int[] arr) {
			int leftBorder = 0;
			int rightBorder = arr.length - 1;
			int mean;

			while (leftBorder < rightBorder) {
				mean = (leftBorder + rightBorder) / 2;
				if (mean != 0 && arr[mean - 1] < arr[mean])
					leftBorder = leftBorder == mean ? leftBorder + 1 : mean;
				if (mean != arr.length - 1 && arr[mean] > arr[mean + 1])
					rightBorder = rightBorder == mean ? rightBorder - 1 : mean;
			}
			return rightBorder;
		}
	}
}