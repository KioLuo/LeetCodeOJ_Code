package Container_with_Most_Water;

/**
 * Created by qy_lu on 2017/8/19.
 */
public class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i < j) {
            if (maxArea < (j - i) * Math.min(height[i], height[j])) {
                maxArea = (j - i) * Math.min(height[i], height[j]);
            }

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
