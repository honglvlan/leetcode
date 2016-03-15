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
public class IntegertoRoman_01 {

    
    public static String intToRoman(int num) {


    	
    	Map<Integer, String> map = new HashMap<Integer, String>() {{   
	    		put(1, "I");   
	    		put(2, "II"); 
	    		put(3, "III");
	    		put(4, "IV");
	    		put(5, "V");
	    		put(6, "VI");
	    		put(7, "VII");
	    		put(8, "VIII");
	    		put(9, "IX");
	    		put(10, "X");
	    		put(20, "XX");
	    		put(30, "XXX");
	    		put(40, "XL");
	    		put(50, "L");
	    		put(60, "LX");
	    		put(70, "LXX");
	    		put(80, "LXXX");
	    		put(90, "XC");
	    		put(100, "C");
	    		put(200, "CC");
	    		put(300, "CCC");
	    		put(400, "CD");
	    		put(500, "D");
	    		put(600, "DC");
	    		put(700, "DCC");
	    		put(800, "DCCC");
	    		put(900, "CM");
	    		put(1000, "M");
	    		put(2000, "MM");
	    		put(3000, "MMM");
    	}};
    
    	
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
    }
    
    public static void main(String[] args)
    {
    	System.out.println(intToRoman(1));
    	System.out.println(intToRoman(2));
    	System.out.println(intToRoman(99));
    }    
}
