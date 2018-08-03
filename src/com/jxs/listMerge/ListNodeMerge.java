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

    public ListNode mergeSolution1(ListNode list1, ListNode list2) {

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

    /**
     * 自己写的方法，好懂
     * */
    public ListNode mergeSolution2(ListNode list1,ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list2 == null && list1 != null) {
            return list1;
        }
        ListNode newNode = new ListNode(0);
        ListNode ret = newNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                newNode.next = new ListNode(list1.val);
                newNode = newNode.next;
                list1 = list1.next;
            } else {
                newNode.next = new ListNode(list2.val);
                newNode = newNode.next;
                list2 = list2.next;
            }
        }

        if (list1 != null && list2 == null) {
            newNode.next = list1;
        } else if (list2 != null && list1 == null) {
            newNode.next = list2;
        }
        return ret.next;
    }

    @Test
    public void test() {

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(3);
        node1.next.next = new ListNode(5);
        ListNode node2 = new ListNode(2);
        node2.next = new ListNode(4);
        node2.next.next = new ListNode(6);

        ListNode node = mergeSolution2(node1, node2);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
