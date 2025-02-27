package leetcodetest;

import common.ListNode;
import org.junit.Test;
import question11_20.Q12;
import question11_20.Q15;
import question11_20.Q17;
import question11_20.Q20;
import question1_10.Q10;
import question1_10.Q6;
import question21_30.Q25;

public class LeetCodeTest {

    @Test
    public void Q25Test(){
        Q25 q25 = new Q25();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        q25.reverseKGroup(node1, 2);
    }
}
