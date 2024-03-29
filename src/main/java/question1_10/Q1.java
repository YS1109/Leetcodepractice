package question1_10;


import java.util.HashMap;

/**
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

public class Q1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (hashMap.containsKey(target - nums[i])){
                return new int[]{hashMap.get(target - nums[i]), i};
            }
            if (!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}


