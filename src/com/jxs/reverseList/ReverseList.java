package com.jxs.reverseList;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/7/4.
 */
public class ReverseList {

    private class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }

        // 上个节点
        ListNode prevNode = head;
        // 当前节点
        ListNode curNode = head.next;
        // 临时节点，用于储存下一节点
        ListNode tempNode;

        while (curNode != null) {

            // 临时节点存放当前节点的下一个节点，防止由于逆转指针指向导致链表断裂
            tempNode = curNode.next;
            // 逆转指针域的指向，将当前节点的下一个节点指向上一个节点
            curNode.next = prevNode;
            // 指针向下移动，上一个节点指向当前节点，当前节点指向下一个节点
            prevNode = curNode;
            curNode = tempNode;
        }
        head.next = null;
        return prevNode;
    }

    @Test
    public void test() {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode node = reverseList(head);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
