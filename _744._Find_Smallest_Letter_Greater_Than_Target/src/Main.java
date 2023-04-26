public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.nextGreatestLetter(new char[]{'b', 'c', 'd'}, 'a') + " expected b");
		System.out.println(solution.nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c') + " expected f");
		System.out.println(solution.nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z') + " expected x");
	}

	static class Solution {
		public char nextGreatestLetter(char[] letters, char target) {
			if (letters[0] > target)
				return letters[0];

			for (char letter : letters) {
				if (letter <= target)
					continue;
				return letter;
			}
			return letters[0];
		}
	}
}