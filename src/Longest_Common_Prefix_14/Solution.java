package Longest_Common_Prefix_14;

/**
 * Created by qy_lu on 2017/10/22.
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = 0;
        char x = 'a';
        OUT:
        for (;;n++) {
            if (strs.length == 0) break;
            for (int i = 0; i < strs.length; i++) {
                if (n >= strs[i].length()) break OUT;
                if (i == 0) {
                    x = strs[i].charAt(n);
                } else {
                    if (x != strs[i].charAt(n)) {
                        break OUT;
                    }
                }
            }
        }
        return n > 0 ? strs[0].substring(0,n) : "";

    }
}
