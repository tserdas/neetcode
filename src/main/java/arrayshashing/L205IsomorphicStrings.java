package arrayshashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class L205IsomorphicStrings {
    /*
    Given two strings s and t, determine if they are isomorphic.

    Two strings s and t are isomorphic if the characters in s can be replaced to get t.

    All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.



    Example 1:

    Input: s = "egg", t = "add"
    Output: true
    Example 2:

    Input: s = "foo", t = "bar"
    Output: false
    Example 3:

    Input: s = "paper", t = "title"
    Output: true


    Constraints:

    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.
     */
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg","add"));
    }
    public static boolean isIsomorphic(String s,String t){
        if(s.length()!=s.length()) return false;
        HashMap<Character, List<Integer>> mapS = new HashMap<>();
        for(int i=0;i<s.length();i++){
            List<Integer> list = mapS.getOrDefault(s.charAt(i),new ArrayList<>());
            list.add(i);
            mapS.put(s.charAt(i),list);
        }
        HashMap<Character,List<Integer>> mapT = new HashMap<>();
        for(int i=0;i<t.length();i++){
            List<Integer> list = mapT.getOrDefault(t.charAt(i),new ArrayList<>());
            list.add(i);
            mapT.put(t.charAt(i),list);
        }
        if(mapS.size()!=mapT.size()) return false;
        HashSet<List<Integer>> setS = new HashSet<>(mapS.values());
        HashSet<List<Integer>> setT = new HashSet<>(mapT.values());
        return setS.equals(setT);
    }
}
