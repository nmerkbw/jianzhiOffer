package com.jxs.listMerge;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/7/4.
 */
public class ListNodeMerge {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode merge(ListNode list1, ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode newNode = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newNode.next = list1;
                list1 = list1.next;
            } else {
                newNode.next = list2;
                list2 = list2.next;
            }
            newNode = newNode.next;
        }
        if (list1 != null) {
            newNode.next = list1;
        }
        if (list2 != null) {
            newNode.next = list2;
        }
        return head.next;
    }

    @Test
    public void test() {

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);
        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(6);

        ListNode node = merge(node1, node2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
