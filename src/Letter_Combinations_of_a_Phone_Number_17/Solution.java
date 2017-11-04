package Letter_Combinations_of_a_Phone_Number_17;

import javax.xml.stream.events.Characters;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by qy_lu on 2017/11/4.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.length() == 0) return ans;
        String[] maps = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int x = 0; x < digits.length(); x++) {
            int num = Character.getNumericValue(digits.charAt(x));
            while (ans.peek().length() == x) {
                String tmp = ans.remove();
                for (char s : maps[num].toCharArray()) {
                    ans.add(tmp + s);
                }
            }
        }
        return ans;
    }
}
