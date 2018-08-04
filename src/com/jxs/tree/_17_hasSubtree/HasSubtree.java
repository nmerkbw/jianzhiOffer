package com.jxs.tree._17_hasSubtree;

import org.junit.Test;

public class HasSubtree {

    private class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasSubtree(TreeNode root1,TreeNode root2) {

        if (root1 == null || root2 == null) {
            return false;
        }
        return isSubtree(root1, root2) || hasSubtree(root1.left, root2) || hasSubtree(root1.right, root2);
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {

        // 先判断 root2是否为空
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }

    @Test
    public void test() {

        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(8);
        root1.left.left = new TreeNode(9);
        root1.left.right = new TreeNode(2);
        root1.left.right.left = new TreeNode(4);
        root1.left.right.right = new TreeNode(7);
        root1.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(8);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(2);

        System.out.println(hasSubtree(root1,root2));
    }
}
