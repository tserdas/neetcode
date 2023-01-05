package arraysHashing;

import java.util.HashSet;

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
