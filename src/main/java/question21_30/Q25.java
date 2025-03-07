package question21_30;

import common.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 输入：head = [1,2,3,4,5], k = 3
 * 输出：[3,2,1,4,5]
 *
 * 输入：head = [1,2,3,4,5], k = 2
 * 输出：[2,1,4,3,5]
 */



public class Q25 {
    // 1 2 3 4 5
    // 2 1 3 4 5
    // 2 1 4 3 5
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode result = null;
        int count = 0;
        ListNode tmpHead = head;
        ListNode totalPreNode = null;
        while (head != null) {
            count++;

            if (count == k) {

                ListNode currentHead = tmpHead;
                ListNode preNode = null;
                ListNode nextNode = currentHead.next;
                // 1 2 3
                for (int i = 0; i < k; i++) {
                    nextNode = currentHead.next;
                    currentHead.next = preNode;
                    preNode = currentHead;
                    currentHead = nextNode;
                }
                if (result == null) {
                    result = preNode;
                }
                tmpHead.next = currentHead;
                if (totalPreNode != null) {
                    totalPreNode.next = preNode;
                }
                totalPreNode = tmpHead;
                tmpHead = nextNode;
                count = 0;
                head = nextNode;
            }
            else {
                head = head.next;
            }

        }
        return result != null ? result : tmpHead;
    }
}
