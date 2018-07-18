package com.jxs._57_getNext;

import org.junit.Test;

public class GetNext {

    private class TreeLinkNode {

        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode getNext(TreeLinkNode pNode) {

        // 情况1 存在右子结点时
        if (pNode.right != null) {
            TreeLinkNode node = pNode.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            // 情况2+情况3 无左右子结点的左孩子和右孩子
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                while (parent.left == pNode) {
                    return parent;
                }
                pNode = pNode.next;
            }
        }
        return null;
    }

    @Test
    public void test() {

        TreeLinkNode pHead = new TreeLinkNode(8);
        pHead.left = new TreeLinkNode(7);
        pHead.left.left = new TreeLinkNode(3);
        pHead.left.left.left = new TreeLinkNode(2);
        pHead.left.left.right = new TreeLinkNode(5);
        pHead.left.left.right.left = new TreeLinkNode(4);
        pHead.left.left.right.right = new TreeLinkNode(6);
        pHead.right = new TreeLinkNode(9);

        System.out.println(getNext(pHead).val);
    }
}
