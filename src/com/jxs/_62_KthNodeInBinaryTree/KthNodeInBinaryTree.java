package com.jxs._62_KthNodeInBinaryTree;

import org.junit.Test;

public class KthNodeInBinaryTree {

    public class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode ret;
    private int cnt = 0;

    public TreeNode kthNode(TreeNode pRoot, int k) {

        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode node, int k) {

        if (node == null) {
            return;
        }
        inOrder(node.left, k);
        cnt++;
        if (cnt == k) {
            ret = node;
        }
        inOrder(node.right, k);
    }

    @Test
    public void test() {

        TreeNode pRoot = new TreeNode(6);
        pRoot.left = new TreeNode(4);
        pRoot.left.left = new TreeNode(3);
        pRoot.left.right = new TreeNode(5);
        pRoot.right = new TreeNode(8);

        System.out.println(kthNode(pRoot, 3).val);
    }
}
