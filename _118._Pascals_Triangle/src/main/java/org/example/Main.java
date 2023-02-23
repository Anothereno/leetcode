package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		printTriangle(solution.generate(1));
		printTriangle(solution.generate(5));
		printTriangle(solution.generate(10));
	}

	static void printTriangle(List<List<Integer>> triangle) {
		for (List<Integer> row : triangle)
			System.out.println(row);
	}

	static class Solution {
		public List<List<Integer>> generate(int numRows) {
			List<List<Integer>> result =  new ArrayList<>();
			List<Integer> previousRow = null;
			for (int i = 1; i <= numRows; i++) {
				List<Integer> insideList = new ArrayList<>();

				if (i == 1) {
					insideList.add(1);
					result.add(insideList);
					previousRow = insideList;
					continue;
				}

				for (int j = 0; j < i; j++)
					if (j == 0 || j == i - 1)
						insideList.add(1);
					else
						insideList.add(previousRow.get(j) + previousRow.get(j - 1));
				result.add(insideList);
				previousRow = insideList;
			}

			return result;
		}
	}
}