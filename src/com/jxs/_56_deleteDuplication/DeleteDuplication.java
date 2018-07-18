package com.jxs._56_deleteDuplication;

import org.junit.Test;

public class DeleteDuplication {

    private class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {

        ListNode prev = null;
        ListNode node = pHead;
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                int value = node.val;
                while (node.next != null && node.next.val == value) {
                    node = node.next;
                }
                if (prev == null) {
                    pHead = node.next;
                } else {
                    prev.next = node.next;
                }
            } else {
                prev = node;
            }
            node = node.next;
        }
        return pHead;
    }

    @Test
    public void test() {

        ListNode pHead = new ListNode(1);
        ListNode node = pHead;
        int[] nums = {1, 2, 3, 3, 5, 5};
        for (int num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
//        while (pHead != null) {
//            System.out.println(pHead.val);
//            pHead = pHead.next;
//        }
        pHead = deleteDuplication(pHead);
        while (pHead != null) {
            System.out.println(pHead.val);
            pHead = pHead.next;
        }
    }
}
