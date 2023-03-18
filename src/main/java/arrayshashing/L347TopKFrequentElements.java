package arrayshashing;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class L347TopKFrequentElements {
    /*
    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.



Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */
    public static void main(String[] args) {
        int[] ex = new int[]{4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(topKFrequent(ex,2)));
    }
    public static int[] topKFrequent(int[] nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] res = new int[k];
        int x = 0;
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        Stream<Map.Entry<Integer,Integer>> sorted = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for(Map.Entry<Integer,Integer> entry : sorted.toList()){
            if(x==k) break;
            res[x] = entry.getKey();
            x++;
        }
        return res;
    }
}
