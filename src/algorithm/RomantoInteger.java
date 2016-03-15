package algorithm;

public class RomantoInteger {
    private static int getValue(char c){
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }	
    }
    public static int romanToInt(String s) {
        
    	int num = 0;
    	int prevmax = 0;
    	
    	for (int i = s.length() - 1; i >= 0; i --)
        {
    		int cur = getValue(s.charAt(i));
    		
    		if (prevmax > cur)
    			num -= cur;
    		else
    		{
    			num += cur;
    			prevmax = cur;
    		}
        }
    	return num;    	
    }
    public static void main(String[] args)
    {
    	System.out.println(romanToInt("II"));
    	System.out.println(romanToInt("VI"));
    	System.out.println(romanToInt("XCIX"));
    }   
}
