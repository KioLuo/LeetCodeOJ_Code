package Palindrome_Number_9;

/**
 * Created by qy_lu on 2017/7/29.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int rev = 0;
        while (rev < x) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;

    }
}
