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

	public static double findKth(int a[], int b[], int k)  
	{  
	    //always assume that m is equal or smaller than n  
	    if (a.length > b.length)  
	        return findKth(b, a, k);  
	    if (a.length == 0)  
	        return b[k - 1];  
	    if (k == 1)  
	        return Math.min(a[0], b[0]);  
	    //divide k into two parts  
	    int pa = Math.min(k / 2, a.length), pb = k - pa;  
	    if (a[pa - 1] < b[pb - 1])  
	    {
	    	int[] sa = Arrays.copyOfRange(a, pa, a.length);
	        return findKth(sa, b, k - pa);
	    }
	    else if (a[pa - 1] > b[pb - 1])
	    {
	    	int[] sb = Arrays.copyOfRange(b, pb, b.length);
	        return findKth(a, sb, k - pb);
	    }
	    else  
	        return a[pa - 1];  
	} 
	
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

	    if (nums1 == null && nums2 == null)
	    	return 0;
	    
	    int total = 0;
	    
	    if (nums1 == null)
	    {
	    	total = nums2.length;
		    if ((total & 1) == 1)
		    {
		    	return nums2[total / 2 + 1];
		    }
		    else
		    {
		    	return (nums2[total / 2] + nums2[total / 2 + 1]) / 2 ;
		    }
	    }
	    else if (nums2 == null)
	    {
	    	total = nums1.length;
		    if ((total & 1) == 1)
		    {
		    	return nums1[total / 2 + 1];
		    }
		    else
		    {
		    	return (nums1[total / 2] + nums1[total / 2 + 1]) / 2 ;
		    }	    	
	    }
	    else	    	
	    {
	    	total = nums1.length + nums2.length;
	    }
	    //odd number
	    if ((total & 1) == 1)
	    {
	    	return findKth(nums1, nums2, total / 2 + 1);
	    }
	    else
	    {
	    	return (findKth(nums1, nums2, total / 2)  
                    + findKth(nums1, nums2, total / 2 + 1)) / 2;
	    }
	    	
	}
	
	
	public static void main(String[] args)
	{
	    int ar1[] = {};
	    int ar2[] = {1};
	    System.out.print(findMedianSortedArrays(ar1, ar2));
	}
}
