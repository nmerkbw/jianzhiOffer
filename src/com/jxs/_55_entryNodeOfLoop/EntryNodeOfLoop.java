package com.jxs._55_entryNodeOfLoop;

import org.junit.Test;

public class EntryNodeOfLoop {

    private class ListNode {

        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode entryNodeOfLoop(ListNode pHead) {

        if (pHead.next == null || pHead == null) {
            return null;
        }
        ListNode nodeSlow = pHead;
        ListNode nodeFast = pHead;
        nodeSlow = nodeSlow.next;
        nodeFast = nodeFast.next.next;
        while (nodeSlow != nodeFast) {
            nodeFast = nodeFast.next.next;
            nodeSlow = nodeSlow.next;
        }
        nodeSlow = pHead;
        while (nodeSlow != nodeFast) {
            nodeFast = nodeFast.next;
            nodeSlow = nodeSlow.next;
        }
        return nodeSlow;
    }

    @Test
    public void test() {

        ListNode node = new ListNode(1);
        int[] nums = {2, 3, 4, 5, 6, 7, 8, 9};
        ListNode pHead = node;
        ListNode entry = node;
        for (int num : nums) {
            node.next = new ListNode(num);
            node = node.next;
        }
        node.next = entry.next.next.next;
        System.out.println(entryNodeOfLoop(pHead).val);
    }
}
