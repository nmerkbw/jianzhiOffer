package com.jxs.rebuildBinaryTree;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RebuildBinaryTree {

    private class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> inOrderNumsIndexs = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        for (int i = 0; i < in.length; i++) {
            inOrderNumsIndexs.put(in[i], i);
        }
        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] pre, int preLeft, int preRight,
                                           int[] in, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        TreeNode root = new TreeNode(pre[preLeft]);
        int index = inOrderNumsIndexs.get(root.val);
        int leftTreeSize = index - inLeft;
        root.left = reConstructBinaryTree(pre, preLeft + 1, preLeft + leftTreeSize, in, inLeft, inLeft + leftTreeSize - 1);
        root.right = reConstructBinaryTree(pre, preLeft + leftTreeSize + 1, preRight, in, inLeft + leftTreeSize + 1, inRight);
        return root;
    }

    private void printTree(TreeNode root) {
        if(root != null) {
            printTree(root.left);
            System.out.println(root.val + " ");
            printTree(root.right);
        }
    }

    @Test
    public void test() {

        RebuildBinaryTree tree = new RebuildBinaryTree();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        TreeNode node = tree.reConstructBinaryTree(pre, in);
        tree.printTree(node);
    }
}
