package ZigZag_Conversion_6;

/**
 * Created by qy_lu on 2017/5/31.
 */
public class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        StringBuffer[] sbs = new StringBuffer[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuffer();
        }

        int i = 0;
        while (i < len) {
            for (int n = 0; n < numRows && i < len; n++) {
                sbs[n].append(s.charAt(i++));
            }

            for (int n = numRows - 2; n >= 1 && i < len; n--) {
                sbs[n].append(s.charAt(i++));
            }
        }

        for (int n = numRows - 1; n >= 1; n--) {
            sbs[n - 1] = sbs[n - 1].append(sbs[n]);
        }
        return sbs[0].toString();
    }
}
