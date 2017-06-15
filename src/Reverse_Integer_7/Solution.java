package Reverse_Integer_7;

/**
 * Created by qy_lu on 2017/6/15.
 */
public class Solution {
    public int reverse(int x) {
        int total = 0;
        int residue = 0;

        while (x != 0) {
            residue = x % 10;
            x /= 10;
            if ((total > Integer.MAX_VALUE / 10) || (total == Integer.MAX_VALUE / 10 && residue > Integer.MAX_VALUE % 10)) {
                total = 0;
                break;
            }
            if ((total < Integer.MIN_VALUE / 10) || (total == Integer.MIN_VALUE / 10 && residue < Integer.MIN_VALUE % 10)) {
                total = 0;
                break;
            }
            total = total * 10 + residue;
        }

        return total;
    }
}
