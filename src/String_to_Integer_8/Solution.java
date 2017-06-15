package String_to_Integer_8;

/**
 * Created by qy_lu on 2017/6/15.
 */
public class Solution {
    public int myAtoi(String str) {
        int index = 0;
        int total = 0;
        int sign = 1;

        if (str.length() == 0) {
            return 0;
        }

        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        if (index < str.length() && (str.charAt(index) == '+' || str.charAt(index) == '-')) {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            int num = str.charAt(index) - '0';
            if ((total > Integer.MAX_VALUE / 10) || (total == Integer.MAX_VALUE / 10 && num > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + num;
            index++;
        }

        total = sign * total;

        return total;
    }
}
