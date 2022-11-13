import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s;

		s = "abccccdd";
		System.out.println(solution.longestPalindrome(s));

		s = "a";
		System.out.println(solution.longestPalindrome(s));

		s = "lol";
		System.out.println(solution.longestPalindrome(s));

		s = "kol";
		System.out.println(solution.longestPalindrome(s));
	}

	static class Solution {
		public int longestPalindrome(String s) {
			HashMap<Character, Integer> amountMap = new HashMap<>();
			char ch;
			for (int i = 0; i < s.length(); i++) {
				ch = s.charAt(i);
				amountMap.computeIfPresent(ch, (k, v) -> v + 1);
				amountMap.putIfAbsent(ch, 1);
			}

			boolean oddWasAdded = false;
			int maxLength = 0;
			int curValue;
			for (Map.Entry<Character, Integer> entry : amountMap.entrySet()) {
				curValue = entry.getValue();
				if (curValue % 2 == 0)
					maxLength += curValue;
				else {
					maxLength += curValue - 1;
					if (!oddWasAdded) {
						oddWasAdded = true;
						maxLength++;
					}
				}
			}
			return maxLength;
		}
	}
}