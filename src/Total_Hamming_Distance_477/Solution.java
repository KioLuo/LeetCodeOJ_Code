package Total_Hamming_Distance_477;

/**
 * Created by qy_lu on 2018/3/17.
 */
public class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        for (int i = 0; i < 32; i++) {
            int n = 0;
            for (int j = 0; j < nums.length; j++) {
                n += (nums[j] >> i) & 1;
            }
            total += n * (nums.length - n);
        }
        return total;
    }
}
