import java.util.Queue;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String str;
		str = "()";
		System.out.println(str + " " + solution.isValid(str));
		str = "()[]{}";
		System.out.println(str + " " + solution.isValid(str));
		str = "(]";
		System.out.println(str + " " + solution.isValid(str));
		str = "(";
		System.out.println(str + " " + solution.isValid(str));
		str = "]";
		System.out.println(str + " " + solution.isValid(str));
	}
	static class Solution {
		public boolean isValid(String s) {
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < s.length(); i++) {
				char ch = s.charAt(i);

				if (ch == '(' || ch == '{' || ch == '[')
					stack.push(ch);
				else if (stack.isEmpty())
					return false;
				else if (ch == '}' && stack.pop() != '{')
					return false;
				else if (ch == ')' && stack.pop() != '(')
					return false;
				else if (ch == ']' && stack.pop() != '[')
					return false;
			}
			return stack.isEmpty();
		}
	}
}