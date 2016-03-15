package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
    	if (nums.length < 3)
    		return 0;    	    	
    	
    	Arrays.sort(nums);	
    	int closest = nums[0] + nums[1] + nums[2];
		
		int current = 0;
		for (int i = 0; i < nums.length - 2;) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				current = nums[i] + nums[j] + nums[k];
				
				if (current == target)
					return target;				
				else if (Math.abs(closest - target) > Math.abs(current - target))
					 closest = current; 
				
				if (current < target) {
					do {
						j++;
					} while (nums[j] == nums[j - 1] && j < k);
				} else {
					do {
						k--;
					} while (nums[k] == nums[k + 1] && k > j);
				}
			}

			do {
				i++;
			} while (nums[i] == nums[i - 1]
					&& (i < nums.length - 2));
		}

		return closest;  
    }
    
    public static void main(String args[])
    {
    	int[] nums = {-3,-2,-5,3,-4};
    			
    	System.out.println(threeSumClosest(nums, -1));
    }
}
