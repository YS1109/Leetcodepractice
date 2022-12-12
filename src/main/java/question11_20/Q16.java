package question11_20;

import java.util.Arrays;

/**
 * 给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 *
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            int start = 0;
            int end = nums.length - 1;
            while (start < end) {
                int currentValue = nums[i] + nums[start] + nums[end];
                if (target == currentValue) {
                    return currentValue;
                }
                if (Math.abs(target - currentValue) < Math.abs(target - result)) {
                    result = currentValue;
                }
                if (currentValue < target) {
                    start++;
                    while (nums[start] == nums[start - 1] && start < end) {
                        start++;
                    }
                    if (start == i) {
                        start++;
                    }
                } else {
                    end--;
                    while (nums[end] == nums[end + 1] && start < end) {
                        end--;
                    }
                    if (end == i) {
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
