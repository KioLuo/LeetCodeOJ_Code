package Generate_Parentheses_22;

import java.util.*;

/**
 * Created by qy_lu on 2018/3/10.
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    void backtrack(List<String> list, String str, int left, int right, int max) {
        if (str.length() == 2 * max) {
            list.add(str);
            return;
        }

        if (left < max) {
            backtrack(list, str + "(", left + 1, right, max);
        }
        if (right < left) {
            backtrack(list, str + ")", left, right + 1, max);
        }
    }
}
