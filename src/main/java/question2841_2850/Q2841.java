package question2841_2850;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.cn/problems/maximum-sum-of-almost-unique-subarray/description/

public class Q2841 {
    public long maxSum(List<Integer> nums, int m, int k) {
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            putNum(map, nums.get(i));
            if (i < k - 1) {
                continue;
            }
            if (keySum(map) >= m) {
                ans = Math.max(ans, sum);
            }
            sum -= nums.get(i - k + 1);
            removeNum(map, nums.get(i - k + 1));
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
