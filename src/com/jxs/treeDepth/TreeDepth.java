package com.jxs.treeDepth;

import org.junit.Test;

public class TreeDepth {

    private class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public int getTreeDepth(TreeNode root) {

        return (root == null) ? 0 : 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
    }

    @Test
    public void test() {

        TreeNode node = new TreeNode(7);
        node.left = new TreeNode(6);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.right = new TreeNode(3);

        System.out.println(getTreeDepth(node));
    }
}
