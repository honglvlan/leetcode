package algorithm;

public class StringtoInteger {
	public static int myAtoi(String str) {
		if (str == null)
			return 0;

		str = str.trim();
		int len = str.length();

		if (str.length() == 0)
			return 0;

		int result = 0;
		boolean negative = false;
		int i = 0;

		if (len > 0) {
			char firstChar = str.charAt(0);
			if (firstChar < '0') { // Possible leading "+" or "-"
				if (firstChar == '-') {
					negative = true;

				} else if (firstChar != '+')
					return 0;

				if (len == 1) // Cannot have lone "+" or "-"
					return 0;
				i++;
			}

			for (; i < len && Character.isDigit(str.charAt(i)); i++) {

				int digit = str.charAt(i) - '0';

				if (negative) {
					if (-result < Integer.MIN_VALUE / 10
							|| (-result == Integer.MIN_VALUE / 10 && -digit < Integer.MIN_VALUE % 10)) {
						return Integer.MIN_VALUE;
					}
				} else {

					if (result > Integer.MAX_VALUE / 10
							|| (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
						return Integer.MAX_VALUE;
				}

				result = result * 10 + digit;
			}
		}
		return negative ? - result : result;
	}

	public static void main(String[] args) {

		System.out.println(myAtoi("-1"));
	}
}
