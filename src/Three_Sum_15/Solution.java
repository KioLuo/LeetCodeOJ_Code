package Three_Sum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qy_lu on 2017/10/22.
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (nums.length < 3) return results;
        int i = 0, j = 1, k;
        while (j < nums.length - 1 && nums[i] + nums[j] <= 0) {
            k = nums.length - 1;
            while (j < nums.length - 1 && nums[i] + nums[j] <= 0) {
                while (j < k && nums[i] + nums[j] >= 0 - nums[k]) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> result = new ArrayList<Integer>();
                        result.add(nums[i]);
                        result.add(nums[j]);
                        result.add(nums[k]);
                        results.add(result);
                        break;
                    }
                    while (k > j && nums[k--] == nums[k])  {}
                }
                while (j < nums.length - 1 && nums[j++] == nums[j]) {}
            }
            while (i < j && nums[i++] == nums[i]) {}
            j = i + 1;
        }
        return results;
    }

    public static void main(String[] args) {
        int[] input = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(new Solution().threeSum(input));
    }
}
