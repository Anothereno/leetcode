public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPalindrome("lol"));
		System.out.println(solution.isPalindrome("lol, dd lol"));
		System.out.println(solution.isPalindrome("kol, dd lol"));
		System.out.println(solution.isPalindrome("kol, ddlok"));
		System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
	}

	static class Solution {
		public boolean isPalindrome(String s) {
			int left = 0;
			int right = s.length() - 1;

			while (left < right) {
				while (left < right && !Character.isAlphabetic(s.charAt(left)) && !Character.isDigit(s.charAt(left)))
					left++;
				while (right > left && !Character.isAlphabetic(s.charAt(right)) && !Character.isDigit(s.charAt(right)))
					right--;

				if (left >= right)
					return true;

				int leftCh = s.charAt(left) > 90 ? s.charAt(left) - 32 : s.charAt(left);
				int rightCh = s.charAt(right) > 90 ? s.charAt(right) - 32 : s.charAt(right);

				if (leftCh != rightCh)
					return false;

				left++;
				right--;
			}
			return true;
		}
	}
}