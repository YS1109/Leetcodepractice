package question1341_1350;

// https://leetcode.cn/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
public class Q1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0;
        int targetSum = threshold * k;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i < k) {
                if (i == k - 1) {
                    ans += sum >= targetSum ? 1 : 0;
                }
                continue;
            }
            sum -= arr[i - k];
            ans += sum >= targetSum ? 1 : 0;
        }
        return ans;
    }
}
