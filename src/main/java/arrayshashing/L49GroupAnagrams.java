package arrayshashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]


Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
public class L49GroupAnagrams {
    public static void main(String[] args) {

    }
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> response = new ArrayList<>();
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            char[] arr = new char[26];
            for(Character c : s.toCharArray()){
                arr[c-'a']++;
            }
            String ns = new String(arr);
            if(map.containsKey(ns)){
                map.get(ns).add(s);
            } else{
                ArrayList<String> ls = new ArrayList<>();
                ls.add(s);
                map.put(ns,ls);
            }
        }
        response.addAll(map.values());
        return response;
    }
}
