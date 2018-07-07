package com.jxs.binaryAndDoubleLinkedList;

import org.junit.Test;

public class BinaryAndDList {

    private class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode head = null;
    private TreeNode pre = null;

    public TreeNode convertBinaryToDList(TreeNode pRootOfTree) {

        convert(pRootOfTree);
        return head;
    }

    private void convert(TreeNode node) {

        if (node == null) {
            return;
        }

        // 第一次：递归到二叉树的最左节点，也就是最小值，找到头结点
        convert(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        if (head == null) {
            head = node;
        }
        convert(node.right);
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode head = convertBinaryToDList(root);
        TreeNode node = head;
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.right;
        }
    }
}
