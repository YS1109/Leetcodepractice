package question1_10;

/**
 * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Q2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode anwserNodeHead = new ListNode(0);
        ListNode presentNode = anwserNodeHead;
        boolean increase = false;
        for (; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next) {
            int sum = l1.val + l2.val;
            if (increase) {
                sum++;
            }
            if (sum >= 10) {
                increase = true;
                presentNode.next = new ListNode(0);
                presentNode = presentNode.next;
                presentNode.val = sum % 10;
            } else {
                increase = false;
                presentNode.next = new ListNode(0);
                presentNode = presentNode.next;
                presentNode.val = sum;
            }
        }
        ListNode longer = (l1 == null ? l2 : l1);
        if (longer != null) {
            presentNode.next = longer;
            while (increase && presentNode.next != null) {
                presentNode = presentNode.next;
                presentNode.val++;
                if (presentNode.val == 10) {
                    presentNode.val = 0;
                } else {
                    increase = false;
                }
            }
        }
        if (increase) {
            presentNode.next = new ListNode(1);
        }
        return anwserNodeHead.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

