package src;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		print(sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
		print(sol.groupAnagrams(new String[]{""}));
		print(sol.groupAnagrams(new String[]{"a"}));
	}

	private static void print(List<List<String>> lists) {
		System.out.print("[");
		for (List<String> list : lists) {
			System.out.print(list);
			System.out.print(", ");
		}
		System.out.print("]");
		System.out.println();
	}

	static class Solution {
		public List<List<String>> groupAnagrams(String[] strs) {
			Map<String, List<String>> cache = new HashMap<>();
			for (String str : strs) {
				String general = getGeneralString(str);
				if (cache.containsKey(general)) {
					cache.get(general).add(str);
				} else {
					List<String> list = new ArrayList<>();
					list.add(str);
					cache.put(general, list);
				}
			}
			return new ArrayList<>(cache.values());
 		}

		private String getGeneralString(String str) {
			int[] letters = new int[26];
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				letters[ch - 97]++;
			}

			StringBuilder resultBuilder = new StringBuilder();
			for (int i = 0; i < letters.length; i++) {
				if (letters[i] == 0)
					continue;

				while (letters[i] > 0) {
					resultBuilder.append((char) (i + 97));
					letters[i]--;
				}
			}

			return resultBuilder.toString();
		}
	}


}