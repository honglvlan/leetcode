package algorithm;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

Subscribe to see which companies asked this question 
I - 1

IV - 4
V - 5

IX - 9
X - 10

XL - 40
L - 50

LX  - 60
LXX - 70
LXXX - 80
XC - 90
C - 100

D - 500
DC - 600
DCC - 700
DCCC - 800
CM - 800
M - 1000

http://blog.csdn.net/gavid0124/article/details/44587209

 */
public class IntegertoRoman {
	private static String[] g = {"", "I","II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	private static  String[] s = {"", "X","XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	private static String[] b = {"", "C","CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	private static String[] q = {"", "M","MM", "MMM"};
    
    public static String intToRoman(int num) {

    	StringBuilder roman = new StringBuilder();
    	return roman.append(q[num / 1000])
    			.append(b[num / 100 % 10])
    			.append(s[num / 10 % 10])
    			.append(g[num % 10]).toString();
    	//return q[num / 1000] + b[num / 100 % 10] + s[num / 10 % 10] + g[num % 10];
    	
    	
    	/*
    	int x;
    	int y = num;
    	String roman = new String();
    	for (int i = 3; i > 0; i --)
    	{
    		x = y / (int) Math.pow(10, i) * (int) Math.pow(10, i);
    		y = y % (int) Math.pow(10, i);
    		if (x > 0)
    			roman += map.get(x);
    	}
    	
    	if (y > 0)
    		roman += map.get(y);
    	
    	return roman;    	
    	*/
    }
    
    public static void main(String[] args)
    {
    	System.out.println(intToRoman(1));
    	System.out.println(intToRoman(100));
    	System.out.println(intToRoman(99));
    }    
}
