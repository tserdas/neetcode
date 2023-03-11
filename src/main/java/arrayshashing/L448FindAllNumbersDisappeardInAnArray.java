package arrayshashing;

import java.util.ArrayList;
import java.util.List;

public class L448FindAllNumbersDisappeardInAnArray {
    /*
    Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n


Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
     */
    public static void main(String[] args) {
        int[] ex = new int[]{4,3,2,7,8,2,3,1};
        List<Integer> res = findDisappearedNumbers(ex);
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
                i--;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) list.add(i + 1);
        }
        return list;
    }
}
