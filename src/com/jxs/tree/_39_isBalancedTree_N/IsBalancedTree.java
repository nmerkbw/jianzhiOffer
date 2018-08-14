package com.jxs.tree._39_isBalancedTree_N;

import org.junit.Test;

public class IsBalancedTree {

    private class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {

        getTreeDepth(root);
        return isBalanced;
    }

    private int getTreeDepth(TreeNode node) {

        if (node == null || !isBalanced) {
            return 0;
        }
        int left = 1 + getTreeDepth(node.left);
        int right = 1 + getTreeDepth(node.right);
        if (Math.abs(left - right) <= 1) {
            isBalanced = true;
        } else {
            isBalanced = false;
        }
        return Math.max(left, right);
    }

    @Test
    public void test() {

        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(5);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        //node.left.right.right = new TreeNode(4);

        System.out.println(IsBalanced_Solution(node));
    }
}
