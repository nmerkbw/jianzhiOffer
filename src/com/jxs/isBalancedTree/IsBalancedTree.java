package com.jxs.isBalancedTree;

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

    public boolean IsBalanced_Solution(TreeNode root) {

        int countL = getTreeLeftDepth(root);
        int countR = getTreeRightDepth(root);
        if (Math.abs(countL - countR) <= 1) {
            return true;
        }
        return false;
    }

    private int getTreeLeftDepth(TreeNode node) {

        return (node == null) ? 0 : 1 + getTreeLeftDepth(node.left);
    }

    private int getTreeRightDepth(TreeNode node) {

        return (node == null) ? 0 : 1 + getTreeRightDepth(node.right);
    }

    @Test
    public void test() {

        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(5);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);
        node.left.right.right = new TreeNode(4);

        System.out.println(IsBalanced_Solution(node));
    }
}
