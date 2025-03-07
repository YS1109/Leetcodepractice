package question21_30;

import common.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 *
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 *
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：lists = [[]]
 * 输出：[]
 *
 *
 * 提示：
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class Q23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode header = null;
        ListNode current = null;

        while (!allListIsEmpty(lists)) {
            Integer min_index = null;
            Integer min_value = null;
            for (int i = 0; i < lists.length; i++) {
                ListNode currentListNode = lists[i];
                if (currentListNode != null) {
                    if (min_index == null) {
                        min_index = i;
                        min_value = currentListNode.val;
                    } else {
                        if (min_value > currentListNode.val) {
                            min_value = currentListNode.val;
                            min_index = i;
                        }
                    }
                }
            }
            if (header == null) {
                header = new ListNode(min_value);
                current = header;
            } else {
                current.next = new ListNode(min_value);
                current = current.next;
            }
            lists[min_index] = lists[min_index].next;
        }

        return header;
    }

    private boolean allListIsEmpty(ListNode[] listNodes) {
        for (ListNode listNode : listNodes) {
            if (listNode != null) {
                return false;
            }
        }
        return true;
    }
}
