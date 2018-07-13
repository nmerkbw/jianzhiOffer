package com.jxs.findFirstCommonNode;

import org.junit.Test;

/**
 *  解题思路：
 *
 * 当访问 A 链表的指针访问到链表尾部时，令它从链表 B 的头部重新开始访问链表 B；
 * 同样地，当访问 B 链表的指针访问到链表尾部时，令它从链表 A 的头部重新开始访问链表 A。
 * 这样就能控制访问 A 和 B 两个链表的指针能同时访问到交点。
 * */
public class FindFirstCommonNode {

    private class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode pNode1 = pHead1;
        ListNode pNode2 = pHead2;
        while (pNode1 != pNode2) {
            pNode1 = (pNode1 == null) ? pHead2 : pNode1.next;
            pNode2 = (pNode2 == null) ? pHead1 : pNode2.next;
        }
        return pNode1;
    }

    @Test
    public void test() {

        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);

        ListNode node2 = new ListNode(9);
        node2.next = node1.next.next;

        System.out.println(findFirstCommonNode(node1,node2).val);
    }
}
