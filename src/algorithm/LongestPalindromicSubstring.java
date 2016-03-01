package algorithm;

//Source : https://oj.leetcode.com/problems/longest-palindromic-substring/
//http://www.cnblogs.com/bitzhuwei/p/Longest-Palindromic-Substring-Part-II.html


/**********************************************************************************
 * 
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 **********************************************************************************/
public class LongestPalindromicSubstring {

	public static String findPalindrom(String s, int left, int right) {		
		int len = s.length();
		if (right > len - 1)
			return s.substring(left, right);;
		
		while (left >= 0 && right <= len - 1
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left+1, right);
	}

	public static String longestPalindrome(String s) {

		String longest = null;
		String str = null;
		for (int i = 0; i <= s.length() - 1; i++) {
			str = findPalindrom(s, i, i);
			if (longest == null || str.length() > longest.length()) {
				longest = str;
			}
			str = findPalindrom(s, i, i + 1);
			
			if (longest == null || str.length() > longest.length()) {
				longest = str;
			}
		}
		return longest;

	}


	
	
	
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome("a"));
	}

}
