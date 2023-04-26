public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		char[] array = new char[] {'a','a','b','b','c','c','c'};
		System.out.println(solution.compress(array));
		System.out.println(array);

		array = new char[] {'a'};
		System.out.println(solution.compress(array));
		System.out.println(array);
	}

	static class Solution {
		public int compress(char[] chars) {
			char prevCh = chars[0];
			int amountOfCh = 1;
			int result = 1;
			int cursor = 1;

			for (int i = 1; i < chars.length; i++) {
				if (chars[i] == prevCh) {
					amountOfCh++;
				} else {
					if (amountOfCh != 1) {
						result += calculateCharacters(amountOfCh);
						cursor += modifyArrayAndGetCharacters(chars, cursor, amountOfCh);
					}

					prevCh = chars[i];
					amountOfCh = 1;
					result++;
					chars[cursor] = chars[i];
					cursor++;
				}
			}
			if (cursor < chars.length)
				modifyArrayAndGetCharacters(chars, cursor, amountOfCh);
			return amountOfCh == 1 ? result : result + calculateCharacters(amountOfCh);
		}

		private int calculateCharacters(int amountOfCh) {
			int result = 0;

			while (amountOfCh > 0) {
				amountOfCh = amountOfCh / 10;
				result++;
			}
			return result;
		}

		private int modifyArrayAndGetCharacters(char[] chars, int cursor, int amount) {
			String number = String.valueOf(amount);
			for (int i = 0; i < number.length(); i++) {
				chars[cursor] = number.charAt(i);
				cursor++;
			}

			return number.length();
		}
	}
}