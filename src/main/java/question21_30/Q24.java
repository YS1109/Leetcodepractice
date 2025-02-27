package question21_30;

/**
 *给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 *
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：head = [1]
 * 输出：[1]
 *
 */

import common.ListNode;

/**
 * 1 2 3 4 5 6 7
 * 2 -> 1 -> 4 -> 3 -> 6 -> 5 -> 7
 */

public class Q24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = head.next;
        ListNode preNode = null;
        while (head != null && head.next != null) {
            if (preNode != null) {
                preNode.next = head.next;
            }
            preNode = head;
            head = head.next;
            ListNode tmpNode = head.next;
            head.next = preNode;
            preNode.next = tmpNode;
            head = tmpNode;
        }
        return result;
    }
}
