package algorithm;

import java.util.*;

/**********************************************************************************
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters. For example, the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 * 
 **********************************************************************************/

public class LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		int start = 0;
		int currentLen = 0;
		//
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			//
			if (map.containsKey(s.charAt(i)) && start <= map.get(s.charAt(i))) {
				start = map.get(s.charAt(i)) + 1;
				max = Math.max(max, currentLen);
				currentLen = i - start;
			}
			currentLen++;
			map.put(s.charAt(i), i);
		}
		max = Math.max(max, currentLen);
		return max;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
		System.out.println(lengthOfLongestSubstring("bbbbb"));
		System.out.println(lengthOfLongestSubstring("abcbedf"));
	}

}
