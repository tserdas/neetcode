package arrayshashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class L290WordPattern {
    /*
    Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.



Example 1:

Input: pattern = "abba", s = "dog cat cat dog"
Output: true
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"
Output: false


Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
     */
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog cat cat fish"));
    }
    public static boolean wordPattern(String pattern,String s){
        List<String> sList = Arrays.stream(s.split(" ")).toList();
        if(pattern.length()!=sList.size()) return false;
        HashMap<Character,String> map = new HashMap<>();
        for(int i=0;i<pattern.length();i++){
            if(map.containsKey(pattern.charAt(i))){
                if(!sList.get(i).equals(map.get(pattern.charAt(i)))) return false;
            }
            else if(map.containsValue(sList.get(i))){
                int x = i;
                AtomicBoolean val = new AtomicBoolean(false);
                map.keySet().forEach(character -> {
                    if(!character.equals(pattern.charAt(x)))
                        val.set(false);
                });
                if(!val.get())
                    return false;
            }
            map.put(pattern.charAt(i),sList.get(i));
        }
        return true;
    }
}
