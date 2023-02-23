package org.example;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.longestValidParentheses("(()"));
		System.out.println(solution.longestValidParentheses(")()())"));
		System.out.println(solution.longestValidParentheses(""));
	}

	static class Solution {
		public int longestValidParentheses(String s) {
			if (s.isEmpty())
				return 0;

			int maxSequenceLength = 0;
			int curSequenceLength = 0;
			boolean openBracket = false;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') {
					openBracket = true;
				} else if (openBracket && s.charAt(i) == ')') {
					curSequenceLength += 2;
					openBracket = false;
				} else {
					curSequenceLength = 0;
					openBracket = false;
				}
				if (curSequenceLength > maxSequenceLength)
					maxSequenceLength = curSequenceLength;
			}
			return maxSequenceLength;
		}
	}
}