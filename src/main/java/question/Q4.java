package question;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * 主要思路：找中位数本质上可以归并到找两个数组第n小的元素的情况，然后二分查找排除一半元素，减少n的值循环查找。
 * 1.合并情况：
 * 因为两个数组的长度和可能是奇数，也可能是偶数。在这里可以合并情况：无论两个数组的和是奇数还是偶数
 * 我们要找的中位数都是第（nums1.length + nums2.length + 1） / 2 和(nums1.length + nums2.length + 2）/ 2个元素的和再除以2
 * 例如：length分别是4和5，要找的就是(4 + 5 + 1) / 2 = 5个元素与(4 + 5 + 2) / 2 = 5个元素的和除以2
 * 如果length是4和6，要找的就是(4 + 6 + 1) / 2 = 5个元素和(4 + 6 + 2) / 2 = 6个元素的和除以2
 *2.结束情况：
 * 一共分为两种：n = 1 时 返回两个数组中第一个元素小的那个， 当一个数组被排除完时，返回另一个数组的第n个元素
 */
public class Q4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double midNum1 = findNthSmallestNum((nums1.length + nums2.length + 1) / 2, nums1, nums2,0 , 0);
        double midNum2 = findNthSmallestNum((nums1.length + nums2.length + 2) / 2, nums1, nums2, 0, 0);
        return (midNum1 + midNum2) / 2 ;
    }

    private double findNthSmallestNum(int index, int[] nums1, int[] nums2, int left1, int left2) {
        if (nums1[((index / 2) - 1) + left1] >= nums2[((index / 2) - 1) + left2]) {
            left2 = ((index / 2) - 1) + left2;
            index = (index - (index / 2)) + 1;
        } else {
            left1 = ((index / 2) - 1) + left1;
            index = (index - (index / 2)) + 1;
        }
        return findNthSmallestNum(index, nums1, nums2, left1 ,left2);
    }
}
