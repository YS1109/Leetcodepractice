package question2081_2090;

import java.util.Arrays;

// https://leetcode.cn/problems/k-radius-subarray-averages/description/
public class Q2090 {
    public int[] getAverages(int[] nums, int k) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i < k * 2) {
                continue;
            }
            ans[i - k] = sum / (k * 2 + 1);
            sum -= nums[i - k * 2];
        }
        return ans;
    }
}
