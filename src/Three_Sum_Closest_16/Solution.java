package Three_Sum_Closest_16;

import java.util.Arrays;

/**
 * Created by qy_lu on 2017/10/28.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) return 0;
        int i = 0, result = nums[0] + nums[1] + nums[nums.length - 1];
        Arrays.sort(nums);
        OUT:
        while (i < nums.length - 2) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > target) {
                    k--;
                } else {
                    j++;
                }
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }
            }
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {-1,2,1,-4};
        int target = 1;
        System.out.println(new Solution().threeSumClosest(input, target));
    }
}
