package com.jxs.linkedList._25_cloneComplexLinkedList_NN;

public class CloneComplexLinkedList {

    private class RandomListNode {

        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public RandomListNode cloneList(RandomListNode pHead) {

        if (pHead == null) {
            return null;
        }

        RandomListNode cur = pHead;
        while (cur != null) {
            RandomListNode clone = new RandomListNode(cur.label);
            clone.next = cur.next;
            cur.next = clone;
            cur = clone.next;
        }

        // 建立随机的连接
        cur = pHead;
        while (cur != null) {
            RandomListNode clone = cur.next;
            if (cur.random != null) {
                clone.random = cur.random.next;
            }
            cur = clone.next;
        }

        // 拆分操作
        cur = pHead;
        RandomListNode cloneHead = pHead.next;
        while (cur.next != null) {
            // 每个节点都要对其下一个节点进行连接
            RandomListNode next = cur.next;
            cur.next = next.next;
            cur = next;
        }
        return cloneHead;
    }
}
