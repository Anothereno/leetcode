import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.generateParenthesis(1));
		System.out.println(solution.generateParenthesis(3));
//		System.out.println(solution.generateParenthesis(8));
	}

	static class Solution {
		public List<String> generateParenthesis(int n) {
			List<String> list = new ArrayList<>();
			recursive(list, "", n, 0, 0);
			return list;
		}

		private void recursive(List<String> list, String curString, int totalPairs, int usedPairs, int openedPar) {
			if (usedPairs == totalPairs) {
				list.add(curString);
				return;
			}

			if (usedPairs + openedPar < totalPairs)
				recursive(list, curString + "(", totalPairs, usedPairs, openedPar + 1);
			if (openedPar != 0)
				recursive(list, curString + ")", totalPairs, usedPairs + 1, openedPar - 1);
		}
	}
}