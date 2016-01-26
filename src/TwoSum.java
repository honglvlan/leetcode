
/**********************************************************************************
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 *
 **********************************************************************************/

public class TwoSum {



    public static int[] twoSum(int[] nums, int target) {

        int[] matchedIdx = new int[2];

        int end = nums.length - 1;
        for (int i = 0; i < nums.length; i ++)
        {
            if (nums[i] + nums[end] == target)
            {
                matchedIdx[0] = i + 1;
                matchedIdx[1] = end + 1;
                break;
            }
            else if (nums[i] + nums[end] > target)
            {
                end --;
                i--;
            }
        }
        return matchedIdx;
    }



    public static void main(String[] args) {
        // write your code here
        int[] nums = {2, 7, 11, 15};

        int[] matched = twoSum(nums, 13);


        System.out.printf("matched index: index1=%d index2=%d", matched[0], matched[1]);
    }
}
