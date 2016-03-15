package algorithm;

import java.util.regex.Pattern;

/*
 * Implement regular expression matching with support for '.' and '*'.

	'.' Matches any single character.
	'*' Matches zero or more of the preceding element.
	
	The matching should cover the entire input string (not partial).
	
	The function prototype should be:
	bool isMatch(const char *s, const char *p)
	
	Some examples:
	isMatch("aa","a") → false
	isMatch("aa","aa") → true
	isMatch("aaa","aa") → false
	isMatch("aa", "a*") → true
	isMatch("aa", ".*") → true
	isMatch("ab", ".*") → true
	isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
	/*
	 * public static boolean isMatch(String s, String p) { if (p.isEmpty()) {
	 * return s.isEmpty(); }
	 * 
	 * 
	 * if (p.length() == 1 || p.charAt(1) != '*') { if (s.isEmpty() ||
	 * (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) { return false; }
	 * else { return isMatch(s.substring(1), p.substring(1)); } }
	 * 
	 * //P.length() >=2 while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) ||
	 * p.charAt(0) == '.')) { if (isMatch(s, p.substring(2))) { return true; } s
	 * = s.substring(1); }
	 * 
	 * return isMatch(s, p.substring(2)); }
	 */

	public static boolean isMatch(String s, String p) {
		
		if (s.isEmpty()) {
			if (p.isEmpty())
				return true;
			else
			{
				if (p.length() == 1 && p.charAt(0) == '*')
					return true;
				else if (p.length() > 1 && p.charAt(1) == '*')
				{
					return isMatch(s, p.substring(2));
				}
				return false;
			}
		}

		if (p.isEmpty()) {
			return s.isEmpty();
		}

		if (p.length() == 1) {
			if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))
				return (s.length() == 1);
			else
				return false;
		}

	/*	
		if (p.charAt(0) == '.') {
			if (p.charAt(1) == '*') {
				if (s.length() == 1)
					return true;

				if (isMatch(s, p.substring(2)))
					return true;
				else if (s.length() >= 2) {
					if (s.charAt(0) == s.charAt(1)) {
						return isMatch(s.substring(1), p);
					} else {
						return isMatch(s.substring(1), p.substring(2));
					}
				}
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}
	*/
		if (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') {
			if (p.charAt(1) == '*') {
				if (isMatch(s, p.substring(2)))
					return true;
				else
					return isMatch(s.substring(1), p);
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		} else if (p.charAt(1) == '*') {
			return isMatch(s, p.substring(2));
		}

		return false;

	}

	public static void main(String[] args) {
		System.out.println("a".substring(1));
		// System.out.println(isMatch("abbbbbba", "ab*ba"));
		System.out.println(isMatch("ab", ".*"));
		System.out.println(isMatch("aaaa", "aaa"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("bc", ".*bc"));
		System.out.println(isMatch("abbc", "a.bc"));
		//System.out.println(isMatch("bc", "a*bc"));

	}
}
