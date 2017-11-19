package Four_Sum_18;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qy_lu on 2017/11/11.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        Arrays.sort(nums);
        int len = nums.length;
        int min = nums[0];
        int max = nums[len - 1];
        if (4 * min > target || 4 * max < target) {
            return res;
        }

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + 3 * max < target) {
                continue;
            }
            if (4 * nums[i] > target) {
                break;
            }
            if (4 * nums[i] == target && i + 3 < len && nums[i] == nums[i + 3]) {
                res.add(Arrays.asList(nums[i], nums[i], nums[i], nums[i]));
                break;
            }
            ThreeSumForFourSum(nums, i + 1, len - 1, target - nums[i], nums[i], res);
        }
        return res;
    }
    public void ThreeSumForFourSum(int[] nums, int start, int end, int target, int fstnum, List<List<Integer>> res) {
        if (end - start + 1 < 3) {
            return;
        }
        for (int i = start; i <= end; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (3 * nums[i] > target) {
                break;
            }
            if (nums[i] + 2 * nums[end] < target) {
                continue;
            }
            if (3 * nums[i] == target && i + 2 <= end && nums[i + 2] == nums[i]) {
                res.add(Arrays.asList(fstnum, nums[i], nums[i], nums[i]));
                break;
            }
            TwoSumForFourSum(nums, i + 1, end, target - nums[i], fstnum, nums[i], res);
        }
    }

    public void TwoSumForFourSum(int[] nums, int start, int end, int target, int fstnum, int scdnum, List<List<Integer>> res) {
        if (end - start + 1 < 2) {
            return;
        }
        if (2 * nums[start] > target) {
            return;
        }
        if (2 * nums[end] < target) {
            return;
        }
        int i = start, j = end;
        while (i < j) {
            if (i > start && j < end && nums[i] == nums[i - 1] && nums[j] == nums[j + 1]) {
                i++;
                j--;
                continue;
            }
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                res.add(Arrays.asList(fstnum, scdnum, nums[i], nums[j]));
                i++;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSum(new int[]{-1,0,-5,-2,-2,-4,0,1,-2}, -9));
    }

}
