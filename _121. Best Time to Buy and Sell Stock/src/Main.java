public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();

		int[] prices;

		prices = new int[] {7,1,5,3,6,4};
		System.out.println(sol.maxProfit(prices));

		prices = new int[] {7,6,4,3,1};
		System.out.println(sol.maxProfit(prices));

		prices = new int[] {0};
		System.out.println(sol.maxProfit(prices));

		prices = new int[] {3};
		System.out.println(sol.maxProfit(prices));

		prices = new int[] {3};
		System.out.println(sol.maxProfit(prices));

		prices = new int[] {1,4,2};
		System.out.println(sol.maxProfit(prices));

		prices = new int[] {3,2,6,5,0,3};
		System.out.println(sol.maxProfit(prices));

		prices = new int[] {3,2,1};
		System.out.println(sol.maxProfit(prices));
	}

	static class Solution {
		public int maxProfit(int[] prices) {
			if (prices.length == 1)
				return 0;
			int minStock = prices[0];
			int maxProfit = 0;
			int curProfit;
			for (int i = 1; i < prices.length; i++) {
				curProfit = prices[i] - minStock;
				if (curProfit > maxProfit)
					maxProfit = curProfit;
				else if (prices[i] < minStock)
					minStock = prices[i];
			}

			return maxProfit;
		}
	}
}