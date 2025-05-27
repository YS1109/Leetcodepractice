package question641_650;

// https://leetcode.cn/problems/maximum-average-subarray-i/description/

public class Q643 {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0;
        int currentSum =0;
        int start = 0;
        int end = k - 1;
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }
        maxSum = currentSum;
        while (end < nums.length - 1) {
            end++;
            currentSum += nums[end];
            currentSum -= nums[start];
            start++;
            maxSum = Math.max(maxSum, currentSum);
        }
        return (maxSum * 1.0) / k;
    }
}
