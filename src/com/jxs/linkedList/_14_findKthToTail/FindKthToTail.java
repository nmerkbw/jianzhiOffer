package com.jxs.linkedList._14_findKthToTail;

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

    public ListNode findKthToTailSolution1(ListNode head,int k) {

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

    /**
     * 快慢指针方法
     * 自己写的
     * */
    public ListNode findKthToTailSolution2(ListNode head,int k) {

        if (k == 0 || head == null) {
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (--k > 0 && fastNode != null) {
            fastNode = fastNode.next;
        }
        if (fastNode == null) {
            return null;
        }
        while (fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return slowNode;
    }

    @Test
    public void test() {

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        //node.next.next.next.next.next = new ListNode(6);

        ListNode returnNode = findKthToTailSolution1(node, 6);
        System.out.println(returnNode.val);
    }
}
