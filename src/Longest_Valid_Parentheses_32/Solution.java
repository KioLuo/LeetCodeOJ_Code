package Longest_Valid_Parentheses_32;

/**
 * Created by qy_lu on 2018/7/21.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int[] len = new int[s.length()];
        int maxLength = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    len[i] = ((i - 2) > 0 ? len[i - 2] : 0) + 2;
                } else if (i - len[i - 1] - 1 >= 0 && s.charAt(i - len[i - 1] - 1) == '(')  {
                    len[i] = ((i - len[i - 1] - 2) > 0 ? len[i - len[i - 1] - 2] : 0) + len[i - 1] + 2;
                }
                maxLength = Math.max(maxLength, len[i]);
            }
        }
        return maxLength;
    }
}
