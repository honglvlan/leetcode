package algorithm;
//Source : https://oj.leetcode.com/problems/zigzag-conversion/


/********************************************************************************** 
* 
* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
* (you may want to display this pattern in a fixed font for better legibility)
* 
* P   A   H   N
* A P L S I I G
* Y   I   R
* 
* And then read line by line: "PAHNAPLSIIGYIR"
* 
* Write the code that will take a string and make this conversion given a number of rows:
* 
* string convert(string text, int nRows);
* 
* convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
* 
*               
**********************************************************************************/


/*
 * suppose given nuber of rows = ROW
 * for any given position of character of the string, how to determin the new position?
 * suppose the new string will be stored as string array, String[] zigzag = new String[ROW] 
 * 
 * split the string by length (ROW + ROW - 2)
 * for each sub string s
 * if (pos < row) then zigzag[pos] += s[pos]
 * else zigzag[2*row - pos - 2]  
 * 
 * 
 */


public class ZigZagConversion {
	public static String convert(String s, int numRows) {
	    //The cases no need to do anything
	    if (numRows <= 1 || numRows >= s.length()) return s;
	     
	    String[] zz = new String[numRows];    
	    
	    int pos = 0;
	    for (int i = 0; i < s.length(); i ++)
	    {
	    	pos = i % (numRows * 2 - 2);
	    	if (pos < numRows) 
	    	{
	    		if (zz[pos] == null) 
	    			zz[pos] = String.valueOf(s.charAt(i));
	    		else
	    			zz[pos] += s.charAt(i);
	    	}
	    	else
	    	{
	    		zz[numRows * 2 - pos - 2] += s.charAt(i);
	    	}
	    }
	    	    
	    String result = new String();
	    for (int i=0; i< numRows; i++){
	        result += zz[i];
	    }
	    return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(convert("PAYPALISHIRING", 3));	//PAHNAPLSIIGYIR
		System.out.println(convert("PAYPALISHIRING", 4));	//PINALSIGYAHRPI	
	}
}
