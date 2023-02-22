package org.example;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.countBits(0)));
		System.out.println(Arrays.toString(solution.countBits(7)));
		System.out.println(Arrays.toString(solution.countBits(15)));
	}

	static class Solution {
		public int[] countBits(int n) {
			int[] array = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				array[i] = Integer.bitCount(i);
			}
			return array;
		}
	}
}

