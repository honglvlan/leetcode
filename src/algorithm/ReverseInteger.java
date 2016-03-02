package algorithm;
/********************************************************************************** 
* 
* Reverse digits of an integer.
* 
* Example1: x =  123, return  321
* Example2: x = -123, return -321
* 
* 
* Have you thought about this?
* 
* Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
* 
* > If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
* 
* > Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, 
*   then the reverse of 1000000003 overflows. How should you handle such cases?
* 
* > Throw an exception? Good, but what if throwing an exception is not an option? 
*   You would then have to re-design the function (ie, add an extra parameter).
* 
*               
**********************************************************************************/


/**
 * @author hy
 *
 */
public class ReverseInteger {

    public static int reverse(int x) {
        
    	//http://stackoverflow.com/questions/13988805/fastest-way-to-get-sign-in-java
    	
    	int result = 0;
    	int carry = 0;
    	while (x != 0)
    	{
    		carry = x % 10;
    		//x /= 10;
    		x = x / 10;
    		
    		if (result > Integer.MAX_VALUE / 10 
    				|| (result == Integer.MAX_VALUE / 10  && carry > Integer.MAX_VALUE % 10)
    				|| result < Integer.MIN_VALUE / 10
    				|| (result == Integer.MIN_VALUE / 10  && carry < Integer.MIN_VALUE % 10)
    				)
    			return 0;
    			    		
    		result = result * 10 + carry;    		
    	}
    	return result;    	
    }
    
    public static void main(String[] args)
    {
    	System.out.println(Integer.MAX_VALUE);
    	System.out.println(reverse(1534236469));
    }
    
	
}
