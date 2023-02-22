public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] mat;
		mat = new int[][] {{2,1,1}, {1,1,0}, {0,1,1}};
		printMatrix(mat);
		System.out.println(solution.orangesRotting(mat));
		mat = new int[][] {{2,1,1},{0,1,1},{1,0,1}};
		printMatrix(mat);
		System.out.println(solution.orangesRotting(mat));
		mat = new int[][] {{0,2}};
		printMatrix(mat);
		System.out.println(solution.orangesRotting(mat));
	}

	static private void printMatrix(int[][] mat) {
		for (int[] row : mat) {
			for (int i : row) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
	}

	static class Solution {
		public int orangesRotting(int[][] grid) {
			int days = 0;
			while (true) {
				int[][] rotted = rottingOranges(grid);
				if (rotted == null)
					break;
				grid = rotted;
				days++;
			}
			return containsFresh(grid) ? -1 : days;
		}

		private boolean containsFresh(int[][] grid) {
			for (int[] ints : grid)
				for (int j = 0; j < grid[0].length; j++)
					if (ints[j] == 1)
						return true;
			return false;
		}

		private int[][] rottingOranges(int[][] grid) {
			int[][] result = new int[grid.length][grid[0].length];
			boolean changed = false;
			int state;

			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid[0].length; j++) {
					if (grid[i][j] == 0 || grid[i][j] == 2)
						result[i][j] = grid[i][j];
					else {
						state = getOrangeState(grid, i, j);
						if (state == 2)
							changed = true;
						result[i][j] = state;
					}
				}
			}
			return changed ? result : null;
		}

		private int getOrangeState(int[][] grid, int i, int j) {
			if (i > 0 && grid[i - 1][j] == 2)
				return 2;
			if (i < grid.length - 1 && grid[i + 1][j] == 2)
				return 2;
			if (j > 0 && grid[i][j - 1] == 2)
				return 2;
			if (j < grid[0].length - 1 && grid[i][j + 1] == 2)
				return 2;
			return 1;
		}
	}
}