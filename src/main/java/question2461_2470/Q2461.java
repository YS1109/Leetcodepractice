package question2461_2470;

// https://leetcode.cn/problems/maximum-sum-of-distinct-subarrays-with-length-k/

import java.util.HashMap;
import java.util.Map;

public class Q2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            putNum(map, nums[i]);
            if (i < k  - 1) {
                continue;
            }
            if (keySum(map) == k) {
                ans = Math.max(ans, sum);
            }
            sum -= nums[i - k + 1];
            removeNum(map, nums[i - k + 1]);
        }
        return ans;
    }

    public void putNum(Map<Integer, Integer> map, int num) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) + 1);
        } else {
            map.put(num, 1);
        }
    }

    public void removeNum(Map<Integer, Integer> map, int num) {
        if (map.containsKey(num)) {
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0) {
                map.remove(num);
            }
        }
    }

    public long keySum(Map<Integer, Integer> map) {
        if (map == null) {
            return 0;
        }
        return map.size();
    }
}
