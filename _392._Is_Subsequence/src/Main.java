public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s, t;
		s = "axc"; t = "ahbgdc";
		System.out.println(solution.isSubsequence(s, t));
		s = "abc"; t = "ahbgdc";
		System.out.println(solution.isSubsequence(s, t));
	}

	static class Solution {
		public boolean isSubsequence(String s, String t) {
			if (s.isEmpty())
				return true;
			if (t.isEmpty() || t.length() < s.length())
				return false;
			int counter = 0;
			char sChar = s.charAt(0);
			char tChar;

			for (int i = 0; i < t.length(); i++) {
				tChar = t.charAt(i);
				if (tChar == sChar) {
					++counter;
					if (counter >= s.length())
						return true;
					sChar = s.charAt(counter);
				}
			}
			return false;
		}
	}
}