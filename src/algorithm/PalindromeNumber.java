package algorithm;

public class PalindromeNumber {
	
	// negative is not Palindrome
    public static boolean isPalindrome_1(int x) {
    	
    	if (x < 0)
    		return false;
    	/*
    	if (x == Integer.MAX_VALUE || x == Integer.MIN_VALUE)
    		return false;
    	x *=  (int)Math.signum(x);
    	int len = (int)Math.log10(x) + 1;
    	*/
    	int len = (int)Math.log10(x) + 1;
    	int left = 0;
    	int right = 0;
    	for (int i = 0; i < len / 2; i ++)
    	{
    		left = x / (int) Math.pow(10, len - i - 1) % 10;
    		right = x / (int) Math.pow(10, i) % 10;
    		if (left != right )
    			return false;
    	}    		    	
        return true;
    }
    
    // copied from
    // https://leetcode.com/discuss/86897/your-runtime-beats-95-51%25-of-java-submissions-sometimes-10ms    
    public static boolean isPalindrome(int x) {
    	
        if (x < 0)
            return false;
        int y = 0, x1 = 1;
        while (x / x1 != 0) {
            y = y * 10 + x % 10;
            x /= 10;
            x1 *= 10;
        }
        return y < 10 * x ? y == x : y / 10 == x;	    	
    }
    
    public static void main(String[] args)
    {
    	System.out.println(isPalindrome_1(-2147447412));
    	System.out.println(isPalindrome_1(-12345));
    	
    	System.out.println(isPalindrome(2147447412));
    }
}
