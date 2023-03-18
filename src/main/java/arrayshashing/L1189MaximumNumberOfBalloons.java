package arrayshashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L1189MaximumNumberOfBalloons {
    /*
    Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.



Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0


Constraints:

1 <= text.length <= 104
text consists of lower case English letters only.
     */
    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }

    public static int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> balloon = new HashMap<>();
        HashMap<Character, Integer> countText = new HashMap<>();

        char[] balloonArray = "balloon".toCharArray();

        for (char c : balloonArray) {
            if (balloon.containsKey(c)) {
                balloon.put(c,balloon.get(c)+1);
            } else {
                balloon.put(c,1);
            }
        }

        char[] countTextArray = text.toCharArray();

        for (char c : countTextArray) {
            if (countText.containsKey(c)) {
                countText.put(c,countText.get(c)+1);
            } else {
                countText.put(c,1);
            }
        }

        int res = text.length();
        for (Character c : balloon.keySet()) {
            res = Math.min(res,countText.getOrDefault(c,0) / balloon.get(c));
        }

        return res;
    }
}
