package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithm.AddTwoNumbers.ListNode;

/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        
		Arrays.sort(nums);
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2 && nums[i] <= 0;) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				if (nums[i] + nums[j] + nums[k] == 0) {
					results.add(Arrays.asList(nums[i], nums[j], nums[k]));
					do {
						j++;
					} while (nums[j] == nums[j - 1] && j < k);

				} else if (nums[i] + nums[j] + nums[k] < 0) {
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
					&& (i < nums.length - 2 && nums[i] <= 0));
		}

		return results;
    }
}
