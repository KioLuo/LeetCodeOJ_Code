package Longest_Substring_Without_Repeating_Characters_3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qy_lu on 2017/5/27.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0, start = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                start = Math.max(map.get(s.charAt(i)), start);
            }
            map.put(s.charAt(i), i);
            maxCount = Math.max(maxCount, i - start);
        }
        return maxCount;
    }
}
