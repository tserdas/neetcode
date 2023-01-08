package arraysHashing;

import java.util.HashSet;
/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109 */
public class L217ContainsDuplicate {
    public static void main(String[] args) {
        int[] ex = new int[]{1,2,3,1};
        System.out.println(containsDuplicate(ex));
    }
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> list = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!list.add(nums[i]))
                return true;
        }
        return false;
    }
}
