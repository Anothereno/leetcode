package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.getRow(0));
		System.out.println(solution.getRow(1));
		System.out.println(solution.getRow(3));
		System.out.println(solution.getRow(5));
		System.out.println(solution.getRow(10));
	}

	static class Solution {
		public List<Integer> getRow(int rowIndex) {
			List<Integer> previousRow = null;
			for (int i = 1; i <= rowIndex + 1; i++) {
				List<Integer> insideList = new ArrayList<>();

				if (i == 1) {
					insideList.add(1);
					previousRow = insideList;
					continue;
				}

				for (int j = 0; j < i; j++)
					if (j == 0 || j == i - 1)
						insideList.add(1);
					else
						insideList.add(previousRow.get(j) + previousRow.get(j - 1));
				previousRow = insideList;
			}

			return previousRow;
		}
	}
}