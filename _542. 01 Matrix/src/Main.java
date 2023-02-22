public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] mat = new int[][] {{0,0,0}, {0,1,0}, {1,1,1}};
		printMatrix(solution.updateMatrix(mat));
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
		public int[][] updateMatrix(int[][] mat) {
			int[][] result = new int[mat.length][mat[0].length];
			int rowLength = mat.length;
			int columnLength = mat[0].length;
			for (int row = 0; row < mat.length; row++) {
				for (int column = 0; column < mat[row].length; column++) {
					if (mat[row][column] == 0)
						processZero(mat, row, column, rowLength, columnLength);
				}
			}
			return mat;
		}

		private void processZero(int[][] mat, int row, int column, int rowLength, int columnLength) {
			int radius = max(row, rowLength - 1 - row, column, columnLength - 1 - column);

			for (int i = 1; i <= radius; i++) {

			}
		}

		private int max(int ... ints) {
			int max = ints[0];
			for (int i = 1; i < ints.length; i++)
				if (ints[i] > max)
					max = ints[i];
			return max;
		}

		private boolean isInBounds(int rowLength, int columnLength, int row, int column) {
			return row >= 0 && row < rowLength && column >= 0 && column < columnLength;
		}
	}
}