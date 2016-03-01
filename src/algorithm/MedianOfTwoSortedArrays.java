package algorithm;
import java.util.*;
//Source : https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
//http://blog.csdn.net/yutianzuijin/article/details/11499917
//http://blog.csdn.net/zxzxy1988/article/details/8587244

/********************************************************************************** 
* 
* There are two sorted arrays A and B of size m and n respectively. 
* Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
*               
**********************************************************************************/
public class MedianOfTwoSortedArrays {

	public static double findKth(int a[], int m, int b[], int n, int k)  
	{  
	    //always assume that m is equal or smaller than n  
	    if (m > n)  
	        return findKth(b, n, a, m, k);  
	    if (m == 0)  
	        return b[k - 1];  
	    if (k == 1)  
	        return Math.min(a[0], b[0]);  
	    //divide k into two parts  
	    int pa = Math.min(k / 2, m), pb = k - pa;  
	    if (a[pa - 1] < b[pb - 1])  
	    {
	    	int[] sa = Arrays.copyOfRange(a, pa, a.length);
	        return findKth(sa, m - pa, b, n, k - pa);
	    }
	    else if (a[pa - 1] > b[pb - 1])
	    {
	    	int[] sb = Arrays.copyOfRange(b, pb, b.length);
	        return findKth(a, m, sb, n - pb, k - pb);
	    }
	    else  
	        return a[pa - 1];  
	} 
	
	
	public static double findMedianSortedArrays(int A[], int m, int B[], int n) {

	    int total = m + n;
	    //odd number
	    if ((total & 1) == 1)
	    {
	    	return findKth(A, m, B, n, total / 2 + 1);
	    }
	    else
	    {
	    	return (findKth(A, m, B, n, total / 2)  
                    + findKth(A, m, B, n, total / 2 + 1)) / 2;
	    }
	    	
	}
	
	
	public static void main(String[] args)
	{
	    int ar1[] = {1, 12, 15, 26, 38};
	    int ar2[] = {2, 13, 17, 30, 45, 50};
	    System.out.print(findMedianSortedArrays(ar1, 5, ar2, 6));
	}
}
