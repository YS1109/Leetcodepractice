package question11_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > 0) {
                break;
            }
            for (int j = nums.length - 1; j > i + 1; j--) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }
                if (nums[j] < 0) {
                    break;
                }
                int targetNum = (nums[i] + nums[j]) * -1;
                if (targetNum < nums[i]) {
                    continue;
                }
                for (int k = i + 1; k < j; k++) {
                    if (nums[k] == targetNum) {
                        result.add(Arrays.asList(nums[i], nums[k], nums[j]));
                        break;
                    } else if (nums[k] > targetNum) {
                        break;
                    }
                }
            }
        }
        return result;
    }
}
