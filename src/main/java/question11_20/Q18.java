package question11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
 *
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 *
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 200
 * -10^9 <= nums[i] <= 10^9
 * -10^9 <= target <= 10^9
 */
public class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int a = 0; a < n - 3; a++) {
            long x = nums[a];
            if (a > 0 && nums[a - 1] == x) {
                continue;
            }
            if (x + nums[a + 1] + nums[a + 2] + nums[a + 3] > target) {
                break;
            }
            if (x + nums[n - 1] + nums[n - 2] + nums[n -3] < target) {
                continue;
            }
            for (int b = a + 1; b < n - 2; b++) {
                long y = nums[b];
                if (b > a + 1 && nums[b - 1] == y) {
                    continue;
                }
                if (x + y + nums[b + 1] + nums[b + 2] > target) {
                    break;
                }
                if (x + y + nums[n - 1] + nums[n - 2] < target) {
                    continue;
                }
                int c = b + 1, d = n - 1;
                while (c < d) {
                    long s = x + y + nums[c] + nums[d];
                    if (s > target) {
                        d--;
                    } else if (s < target) {
                        c++;
                    } else {
                        result.add(Arrays.asList((int) x, (int) y, nums[c], nums[d]));
                        for (c++; c < d && nums[c] == nums[c - 1]; c++) {}
                        for (d--; d > c && nums[d] == nums[d + 1]; d--) {}
                    }
                }
            }
        }
        return result;
    }
}
