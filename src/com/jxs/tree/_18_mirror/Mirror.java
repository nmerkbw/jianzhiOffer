package com.jxs.tree._18_mirror;

import org.junit.Test;

/**
 * Created by jiangxs on 2018/7/5.
 */
public class Mirror {

    public class TreeNode {

        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void mirror(TreeNode root) {

        if (root == null) {
            return;
        }
        swap(root);
        mirror(root.left);
        mirror(root.right);
    }

    private void swap(TreeNode root) {

        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
    }

    @Test
    public void test() {

        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        mirror(root);
        System.out.println();
    }
}
