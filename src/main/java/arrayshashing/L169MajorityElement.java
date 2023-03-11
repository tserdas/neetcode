package arrayshashing;

public class L169MajorityElement {
    /*
    Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.



Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2


Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109


Follow-up: Could you solve the problem in linear time and in O(1) space?
     */
    public static void main(String[] args) {
        int[] ex = new int[]{3,2,3};
        System.out.println(majorityElement(ex));
    }
    public static int majorityElement(int [] nums){
        int res = 0, count = 0;

        for(int n: nums) {
            if(count == 0)
                res = n;
            count += (n == res? 1: -1);
        }

        return res;
    }
}
