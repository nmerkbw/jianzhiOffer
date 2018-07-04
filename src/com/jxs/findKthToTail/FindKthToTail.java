package com.jxs.findKthToTail;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/7/4.
 */
public class FindKthToTail {


    private class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findKthToTail(ListNode head,int k) {

        if (head == null || k == 0) {
            return null;
        }
        int index = 0;
        ListNode node2 = head;
        for (ListNode node1 = head; node1.next != null; node1 = node1.next) {
            index++;
            if (index >= k) {
                node2 = node2.next;
            }
            if (node1.next.next == null && index + 2 <= k) {
                return null;
            }
        }
        return node2;
    }

    @Test
    public void test() {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        //node.next.next.next.next.next = new ListNode(6);

        ListNode returnNode = findKthToTail(node, 6);
        System.out.println(returnNode.val);
    }
}
