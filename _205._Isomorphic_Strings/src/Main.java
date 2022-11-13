import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s, t;
//		s = "egg"; t = "add";
//		System.out.println(solution.isIsomorphic(s, t));
//		s = "foo"; t = "bar";
//		System.out.println(solution.isIsomorphic(s, t));
		s = "badc"; t = "baba";
		System.out.println(solution.isIsomorphic(s, t));
	}

	static class Solution {
		public boolean isIsomorphic(String s, String t) {
			if (s.length() != t.length())
				return false;

			Map<Character, Character> hash = new HashMap<>();
			char srcChar;
			char destChar;

			for (int i = 0; i < s.length(); i++) {
				srcChar = s.charAt(i);
				destChar = t.charAt(i);
				if (!hash.containsKey(srcChar)) {
					if (hash.containsValue(destChar))
						return false;
					hash.put(srcChar, destChar);
				} else if (hash.get(srcChar) != destChar)
						return false;
			}

			return true;
		}
	}
}