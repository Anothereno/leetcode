import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		String s = "2[abc]3[cd]ef";

		Solution solution = new Solution();
		System.out.println(solution.decodeString(s));
	}

	static class Solution {
		public String decodeString(String s) {
			return getSubstring(s);
		}

		private String getSubstring(String s) {
			int index = 0;
			int startIndex = index;

			while (Character.isDigit(s.charAt(index)))
				index++;


			int repeat = Integer.parseInt(s.substring(startIndex, index));
			Stack<Integer> stack = new Stack<>();

			StringBuilder tmp = new StringBuilder();
			StringBuilder builder = new StringBuilder();

			while (index < s.length()) {
				switch (s.charAt(index)) {
					case '[':
						stack.push(index);
						break;
					case ']':
						if (stack.size() != 1)
							tmp.append(getSubstring(s.substring(stack.pop(), index + 1)));
						else {
							builder.append(multiplier(tmp, repeat));
						}
						stack.pop();
						break;
					default:
						tmp.append(s.charAt(index));
				}
				index++;
			}
			return multiplier(builder, repeat);
		}

		private String multiplier(StringBuilder builder, int repeat) {
			String processedString = builder.toString();
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < repeat; i++)
				result.append(processedString);

			return result.toString();

		}
	}
}
