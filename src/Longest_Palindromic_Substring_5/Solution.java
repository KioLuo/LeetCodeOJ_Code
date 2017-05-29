package Longest_Palindromic_Substring_5;

/**
 * Created by qy_lu on 2017/5/29.
 */
public class Solution {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int aLen = expandCircle(s, i, i);
            int bLen = expandCircle(s, i, i + 1);
            int localMax = Math.max(aLen, bLen);
            if (localMax > end - start + 1) {
                start = i - (localMax - 1) / 2;
                end = start + localMax - 1;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandCircle(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

}
